package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder;
import fpml.confirmation.PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilderImpl;
import fpml.confirmation.PostTradeEventsBaseModel.PostTradeEventsBaseModelImpl;
import fpml.confirmation.PostTradeEventsBaseModelSequence;
import fpml.confirmation.TradeAmendmentContent;
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.TradeNovationContent;
import fpml.confirmation.Withdrawal;
import fpml.confirmation.meta.PostTradeEventsBaseModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between amendment, increase, termination, and novation events.
 * @version ${project.version}
 */
@RosettaDataType(value="PostTradeEventsBaseModel", builder=PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilderImpl.class, version="${project.version}")
public interface PostTradeEventsBaseModel extends RosettaModelObject {

	PostTradeEventsBaseModelMeta metaData = new PostTradeEventsBaseModelMeta();

	/*********************** Getter Methods  ***********************/
	TradeAmendmentContent getAmendment();
	TradeNotionalChange getIncrease();
	PostTradeEventsBaseModelSequence getPostTradeEventsBaseModelSequence();
	TradeNovationContent getNovation();
	Withdrawal getWithdrawal();

	/*********************** Build Methods  ***********************/
	PostTradeEventsBaseModel build();
	
	PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder toBuilder();
	
	static PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder builder() {
		return new PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostTradeEventsBaseModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PostTradeEventsBaseModel> getType() {
		return PostTradeEventsBaseModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.class, getAmendment());
		processRosetta(path.newSubPath("increase"), processor, TradeNotionalChange.class, getIncrease());
		processRosetta(path.newSubPath("postTradeEventsBaseModelSequence"), processor, PostTradeEventsBaseModelSequence.class, getPostTradeEventsBaseModelSequence());
		processRosetta(path.newSubPath("novation"), processor, TradeNovationContent.class, getNovation());
		processRosetta(path.newSubPath("withdrawal"), processor, Withdrawal.class, getWithdrawal());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostTradeEventsBaseModelBuilder extends PostTradeEventsBaseModel, RosettaModelObjectBuilder {
		TradeAmendmentContent.TradeAmendmentContentBuilder getOrCreateAmendment();
		TradeAmendmentContent.TradeAmendmentContentBuilder getAmendment();
		TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateIncrease();
		TradeNotionalChange.TradeNotionalChangeBuilder getIncrease();
		PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder getOrCreatePostTradeEventsBaseModelSequence();
		PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder getPostTradeEventsBaseModelSequence();
		TradeNovationContent.TradeNovationContentBuilder getOrCreateNovation();
		TradeNovationContent.TradeNovationContentBuilder getNovation();
		Withdrawal.WithdrawalBuilder getOrCreateWithdrawal();
		Withdrawal.WithdrawalBuilder getWithdrawal();
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setAmendment(TradeAmendmentContent amendment);
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setIncrease(TradeNotionalChange increase);
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setPostTradeEventsBaseModelSequence(PostTradeEventsBaseModelSequence postTradeEventsBaseModelSequence);
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setNovation(TradeNovationContent novation);
		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setWithdrawal(Withdrawal withdrawal);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.TradeAmendmentContentBuilder.class, getAmendment());
			processRosetta(path.newSubPath("increase"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getIncrease());
			processRosetta(path.newSubPath("postTradeEventsBaseModelSequence"), processor, PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder.class, getPostTradeEventsBaseModelSequence());
			processRosetta(path.newSubPath("novation"), processor, TradeNovationContent.TradeNovationContentBuilder.class, getNovation());
			processRosetta(path.newSubPath("withdrawal"), processor, Withdrawal.WithdrawalBuilder.class, getWithdrawal());
		}
		

		PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder prune();
	}

	/*********************** Immutable Implementation of PostTradeEventsBaseModel  ***********************/
	class PostTradeEventsBaseModelImpl implements PostTradeEventsBaseModel {
		private final TradeAmendmentContent amendment;
		private final TradeNotionalChange increase;
		private final PostTradeEventsBaseModelSequence postTradeEventsBaseModelSequence;
		private final TradeNovationContent novation;
		private final Withdrawal withdrawal;
		
		protected PostTradeEventsBaseModelImpl(PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder builder) {
			this.amendment = ofNullable(builder.getAmendment()).map(f->f.build()).orElse(null);
			this.increase = ofNullable(builder.getIncrease()).map(f->f.build()).orElse(null);
			this.postTradeEventsBaseModelSequence = ofNullable(builder.getPostTradeEventsBaseModelSequence()).map(f->f.build()).orElse(null);
			this.novation = ofNullable(builder.getNovation()).map(f->f.build()).orElse(null);
			this.withdrawal = ofNullable(builder.getWithdrawal()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amendment")
		public TradeAmendmentContent getAmendment() {
			return amendment;
		}
		
		@Override
		@RosettaAttribute("increase")
		public TradeNotionalChange getIncrease() {
			return increase;
		}
		
		@Override
		@RosettaAttribute("postTradeEventsBaseModelSequence")
		public PostTradeEventsBaseModelSequence getPostTradeEventsBaseModelSequence() {
			return postTradeEventsBaseModelSequence;
		}
		
		@Override
		@RosettaAttribute("novation")
		public TradeNovationContent getNovation() {
			return novation;
		}
		
		@Override
		@RosettaAttribute("withdrawal")
		public Withdrawal getWithdrawal() {
			return withdrawal;
		}
		
		@Override
		public PostTradeEventsBaseModel build() {
			return this;
		}
		
		@Override
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder toBuilder() {
			PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder builder) {
			ofNullable(getAmendment()).ifPresent(builder::setAmendment);
			ofNullable(getIncrease()).ifPresent(builder::setIncrease);
			ofNullable(getPostTradeEventsBaseModelSequence()).ifPresent(builder::setPostTradeEventsBaseModelSequence);
			ofNullable(getNovation()).ifPresent(builder::setNovation);
			ofNullable(getWithdrawal()).ifPresent(builder::setWithdrawal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostTradeEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(amendment, _that.getAmendment())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(postTradeEventsBaseModelSequence, _that.getPostTradeEventsBaseModelSequence())) return false;
			if (!Objects.equals(novation, _that.getNovation())) return false;
			if (!Objects.equals(withdrawal, _that.getWithdrawal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amendment != null ? amendment.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModelSequence != null ? postTradeEventsBaseModelSequence.hashCode() : 0);
			_result = 31 * _result + (novation != null ? novation.hashCode() : 0);
			_result = 31 * _result + (withdrawal != null ? withdrawal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostTradeEventsBaseModel {" +
				"amendment=" + this.amendment + ", " +
				"increase=" + this.increase + ", " +
				"postTradeEventsBaseModelSequence=" + this.postTradeEventsBaseModelSequence + ", " +
				"novation=" + this.novation + ", " +
				"withdrawal=" + this.withdrawal +
			'}';
		}
	}

	/*********************** Builder Implementation of PostTradeEventsBaseModel  ***********************/
	class PostTradeEventsBaseModelBuilderImpl implements PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder {
	
		protected TradeAmendmentContent.TradeAmendmentContentBuilder amendment;
		protected TradeNotionalChange.TradeNotionalChangeBuilder increase;
		protected PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder postTradeEventsBaseModelSequence;
		protected TradeNovationContent.TradeNovationContentBuilder novation;
		protected Withdrawal.WithdrawalBuilder withdrawal;
	
		public PostTradeEventsBaseModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amendment")
		public TradeAmendmentContent.TradeAmendmentContentBuilder getAmendment() {
			return amendment;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder getOrCreateAmendment() {
			TradeAmendmentContent.TradeAmendmentContentBuilder result;
			if (amendment!=null) {
				result = amendment;
			}
			else {
				result = amendment = TradeAmendmentContent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("increase")
		public TradeNotionalChange.TradeNotionalChangeBuilder getIncrease() {
			return increase;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateIncrease() {
			TradeNotionalChange.TradeNotionalChangeBuilder result;
			if (increase!=null) {
				result = increase;
			}
			else {
				result = increase = TradeNotionalChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postTradeEventsBaseModelSequence")
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder getPostTradeEventsBaseModelSequence() {
			return postTradeEventsBaseModelSequence;
		}
		
		@Override
		public PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder getOrCreatePostTradeEventsBaseModelSequence() {
			PostTradeEventsBaseModelSequence.PostTradeEventsBaseModelSequenceBuilder result;
			if (postTradeEventsBaseModelSequence!=null) {
				result = postTradeEventsBaseModelSequence;
			}
			else {
				result = postTradeEventsBaseModelSequence = PostTradeEventsBaseModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novation")
		public TradeNovationContent.TradeNovationContentBuilder getNovation() {
			return novation;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder getOrCreateNovation() {
			TradeNovationContent.TradeNovationContentBuilder result;
			if (novation!=null) {
				result = novation;
			}
			else {
				result = novation = TradeNovationContent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("withdrawal")
		public Withdrawal.WithdrawalBuilder getWithdrawal() {
			return withdrawal;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder getOrCreateWithdrawal() {
			Withdrawal.WithdrawalBuilder result;
			if (withdrawal!=null) {
				result = withdrawal;
			}
			else {
				result = withdrawal = Withdrawal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amendment")
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setAmendment(TradeAmendmentContent amendment) {
			this.amendment = amendment==null?null:amendment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("increase")
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setIncrease(TradeNotionalChange increase) {
			this.increase = increase==null?null:increase.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("postTradeEventsBaseModelSequence")
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setPostTradeEventsBaseModelSequence(PostTradeEventsBaseModelSequence postTradeEventsBaseModelSequence) {
			this.postTradeEventsBaseModelSequence = postTradeEventsBaseModelSequence==null?null:postTradeEventsBaseModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novation")
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setNovation(TradeNovationContent novation) {
			this.novation = novation==null?null:novation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("withdrawal")
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder setWithdrawal(Withdrawal withdrawal) {
			this.withdrawal = withdrawal==null?null:withdrawal.toBuilder();
			return this;
		}
		
		@Override
		public PostTradeEventsBaseModel build() {
			return new PostTradeEventsBaseModel.PostTradeEventsBaseModelImpl(this);
		}
		
		@Override
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder prune() {
			if (amendment!=null && !amendment.prune().hasData()) amendment = null;
			if (increase!=null && !increase.prune().hasData()) increase = null;
			if (postTradeEventsBaseModelSequence!=null && !postTradeEventsBaseModelSequence.prune().hasData()) postTradeEventsBaseModelSequence = null;
			if (novation!=null && !novation.prune().hasData()) novation = null;
			if (withdrawal!=null && !withdrawal.prune().hasData()) withdrawal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmendment()!=null && getAmendment().hasData()) return true;
			if (getIncrease()!=null && getIncrease().hasData()) return true;
			if (getPostTradeEventsBaseModelSequence()!=null && getPostTradeEventsBaseModelSequence().hasData()) return true;
			if (getNovation()!=null && getNovation().hasData()) return true;
			if (getWithdrawal()!=null && getWithdrawal().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder o = (PostTradeEventsBaseModel.PostTradeEventsBaseModelBuilder) other;
			
			merger.mergeRosetta(getAmendment(), o.getAmendment(), this::setAmendment);
			merger.mergeRosetta(getIncrease(), o.getIncrease(), this::setIncrease);
			merger.mergeRosetta(getPostTradeEventsBaseModelSequence(), o.getPostTradeEventsBaseModelSequence(), this::setPostTradeEventsBaseModelSequence);
			merger.mergeRosetta(getNovation(), o.getNovation(), this::setNovation);
			merger.mergeRosetta(getWithdrawal(), o.getWithdrawal(), this::setWithdrawal);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostTradeEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(amendment, _that.getAmendment())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(postTradeEventsBaseModelSequence, _that.getPostTradeEventsBaseModelSequence())) return false;
			if (!Objects.equals(novation, _that.getNovation())) return false;
			if (!Objects.equals(withdrawal, _that.getWithdrawal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amendment != null ? amendment.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (postTradeEventsBaseModelSequence != null ? postTradeEventsBaseModelSequence.hashCode() : 0);
			_result = 31 * _result + (novation != null ? novation.hashCode() : 0);
			_result = 31 * _result + (withdrawal != null ? withdrawal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostTradeEventsBaseModelBuilder {" +
				"amendment=" + this.amendment + ", " +
				"increase=" + this.increase + ", " +
				"postTradeEventsBaseModelSequence=" + this.postTradeEventsBaseModelSequence + ", " +
				"novation=" + this.novation + ", " +
				"withdrawal=" + this.withdrawal +
			'}';
		}
	}
}
