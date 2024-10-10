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
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilderImpl;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceImpl;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.meta.LoanBulkServicingNotificationChoiceChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LoanBulkServicingNotificationChoiceChoice", builder=LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilderImpl.class, version="${project.version}")
public interface LoanBulkServicingNotificationChoiceChoice extends RosettaModelObject {

	LoanBulkServicingNotificationChoiceChoiceMeta metaData = new LoanBulkServicingNotificationChoiceChoiceMeta();

	/*********************** Getter Methods  ***********************/
	LetterOfCreditDetailsModel getLetterOfCreditDetailsModel();
	LoanContractDetailsModel getLoanContractDetailsModel();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotificationChoiceChoice build();
	
	LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder toBuilder();
	
	static LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder builder() {
		return new LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotificationChoiceChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanBulkServicingNotificationChoiceChoice> getType() {
		return LoanBulkServicingNotificationChoiceChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("letterOfCreditDetailsModel"), processor, LetterOfCreditDetailsModel.class, getLetterOfCreditDetailsModel());
		processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.class, getLoanContractDetailsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationChoiceChoiceBuilder extends LoanBulkServicingNotificationChoiceChoice, RosettaModelObjectBuilder {
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getOrCreateLetterOfCreditDetailsModel();
		LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getLetterOfCreditDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel();
		LoanContractDetailsModel.LoanContractDetailsModelBuilder getLoanContractDetailsModel();
		LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder setLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel);
		LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder setLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("letterOfCreditDetailsModel"), processor, LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder.class, getLetterOfCreditDetailsModel());
			processRosetta(path.newSubPath("loanContractDetailsModel"), processor, LoanContractDetailsModel.LoanContractDetailsModelBuilder.class, getLoanContractDetailsModel());
		}
		

		LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotificationChoiceChoice  ***********************/
	class LoanBulkServicingNotificationChoiceChoiceImpl implements LoanBulkServicingNotificationChoiceChoice {
		private final LetterOfCreditDetailsModel letterOfCreditDetailsModel;
		private final LoanContractDetailsModel loanContractDetailsModel;
		
		protected LoanBulkServicingNotificationChoiceChoiceImpl(LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder builder) {
			this.letterOfCreditDetailsModel = ofNullable(builder.getLetterOfCreditDetailsModel()).map(f->f.build()).orElse(null);
			this.loanContractDetailsModel = ofNullable(builder.getLoanContractDetailsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("letterOfCreditDetailsModel")
		public LetterOfCreditDetailsModel getLetterOfCreditDetailsModel() {
			return letterOfCreditDetailsModel;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public LoanContractDetailsModel getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		@Override
		public LoanBulkServicingNotificationChoiceChoice build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder toBuilder() {
			LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder builder) {
			ofNullable(getLetterOfCreditDetailsModel()).ifPresent(builder::setLetterOfCreditDetailsModel);
			ofNullable(getLoanContractDetailsModel()).ifPresent(builder::setLoanContractDetailsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoiceChoice _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditDetailsModel, _that.getLetterOfCreditDetailsModel())) return false;
			if (!Objects.equals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditDetailsModel != null ? letterOfCreditDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoiceChoice {" +
				"letterOfCreditDetailsModel=" + this.letterOfCreditDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotificationChoiceChoice  ***********************/
	class LoanBulkServicingNotificationChoiceChoiceBuilderImpl implements LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder {
	
		protected LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder letterOfCreditDetailsModel;
		protected LoanContractDetailsModel.LoanContractDetailsModelBuilder loanContractDetailsModel;
	
		public LoanBulkServicingNotificationChoiceChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("letterOfCreditDetailsModel")
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getLetterOfCreditDetailsModel() {
			return letterOfCreditDetailsModel;
		}
		
		@Override
		public LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder getOrCreateLetterOfCreditDetailsModel() {
			LetterOfCreditDetailsModel.LetterOfCreditDetailsModelBuilder result;
			if (letterOfCreditDetailsModel!=null) {
				result = letterOfCreditDetailsModel;
			}
			else {
				result = letterOfCreditDetailsModel = LetterOfCreditDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder getLoanContractDetailsModel() {
			return loanContractDetailsModel;
		}
		
		@Override
		public LoanContractDetailsModel.LoanContractDetailsModelBuilder getOrCreateLoanContractDetailsModel() {
			LoanContractDetailsModel.LoanContractDetailsModelBuilder result;
			if (loanContractDetailsModel!=null) {
				result = loanContractDetailsModel;
			}
			else {
				result = loanContractDetailsModel = LoanContractDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditDetailsModel")
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder setLetterOfCreditDetailsModel(LetterOfCreditDetailsModel letterOfCreditDetailsModel) {
			this.letterOfCreditDetailsModel = letterOfCreditDetailsModel==null?null:letterOfCreditDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractDetailsModel")
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder setLoanContractDetailsModel(LoanContractDetailsModel loanContractDetailsModel) {
			this.loanContractDetailsModel = loanContractDetailsModel==null?null:loanContractDetailsModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoiceChoice build() {
			return new LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceImpl(this);
		}
		
		@Override
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder prune() {
			if (letterOfCreditDetailsModel!=null && !letterOfCreditDetailsModel.prune().hasData()) letterOfCreditDetailsModel = null;
			if (loanContractDetailsModel!=null && !loanContractDetailsModel.prune().hasData()) loanContractDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLetterOfCreditDetailsModel()!=null && getLetterOfCreditDetailsModel().hasData()) return true;
			if (getLoanContractDetailsModel()!=null && getLoanContractDetailsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder o = (LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder) other;
			
			merger.mergeRosetta(getLetterOfCreditDetailsModel(), o.getLetterOfCreditDetailsModel(), this::setLetterOfCreditDetailsModel);
			merger.mergeRosetta(getLoanContractDetailsModel(), o.getLoanContractDetailsModel(), this::setLoanContractDetailsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoiceChoice _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditDetailsModel, _that.getLetterOfCreditDetailsModel())) return false;
			if (!Objects.equals(loanContractDetailsModel, _that.getLoanContractDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditDetailsModel != null ? letterOfCreditDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanContractDetailsModel != null ? loanContractDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoiceChoiceBuilder {" +
				"letterOfCreditDetailsModel=" + this.letterOfCreditDetailsModel + ", " +
				"loanContractDetailsModel=" + this.loanContractDetailsModel +
			'}';
		}
	}
}
