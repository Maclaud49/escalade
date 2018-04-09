package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.exception.FunctionalException;

import javax.inject.Inject;
import java.util.List;

public class CommentsAjaxAction extends ActionSupport {
    

        // ==================== Attributs ====================
        @Inject
        private ManagerFactory managerFactory;

        // -----Elements en entrée
        private String pSection;
        private int pArticle;
        private Commentaire newComment;

        // ----- Eléments en sortie
        private List<Commentaire> listCommentaires;


        // ==================== Getters/Setters ====================
        public List<Commentaire> getListCommentaires() {
            return listCommentaires;
        }

        public String getpSection() {
        return pSection;
        }

        public void setpSection(String pSection) {
            this.pSection = pSection;
        }

        public int getpArticle() {
            return pArticle;
        }

        public void setpArticle(int pArticle) {
            this.pArticle = pArticle;
        }

        public Commentaire getNewComment() {
            return newComment;
        }

        public void setNewComment(Commentaire newComment) {
            this.newComment = newComment;
        }

    // ==================== Méthodes ====================
        public String execute() {
            return ActionSupport.SUCCESS;
        }


        /**
         * Action "AJAX" renvoyant la liste des commentaires
         * @return success
         */
        public String doAjaxGetListCommentaire() {
            //Save the new comment
            try {
                managerFactory.getCommentaireManager().insert(newComment);
            } catch (FunctionalException e) {
                e.printStackTrace();
            }
            listCommentaires = managerFactory.getCommentaireManager().findAllBySectionAndArticle(pSection,pArticle);
            return ActionSupport.SUCCESS;
        }
    }

