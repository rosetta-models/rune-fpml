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
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import fpml.confirmation.LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder;
import fpml.confirmation.LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1BuilderImpl;
import fpml.confirmation.LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Impl;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice;
import fpml.confirmation.meta.LoanBulkServicingNotificationChoice1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanBulkServicingNotificationChoice1", builder=LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanBulkServicingNotificationChoice1 extends RosettaModelObject {

	LoanBulkServicingNotificationChoice1Meta metaData = new LoanBulkServicingNotificationChoice1Meta();

	/*********************** Getter Methods  ***********************/
	FacilityDetailsModel getFacilityDetailsModel();
	LoanBulkServicingNotificationChoiceChoice getLoanBulkServicingNotificationChoiceChoice();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotificationChoice1 build();
	
	LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder toBuilder();
	
	static LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder builder() {
		return new LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotificationChoice1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanBulkServicingNotificationChoice1> getType() {
		return LoanBulkServicingNotificationChoice1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.class, getFacilityDetailsModel());
		processRosetta(path.newSubPath("loanBulkServicingNotificationChoiceChoice"), processor, LoanBulkServicingNotificationChoiceChoice.class, getLoanBulkServicingNotificationChoiceChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationChoice1Builder extends LoanBulkServicingNotificationChoice1, RosettaModelObjectBuilder {
		FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel();
		FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel();
		LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder getOrCreateLoanBulkServicingNotificationChoiceChoice();
		LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder getLoanBulkServicingNotificationChoiceChoice();
		LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel);
		LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder setLoanBulkServicingNotificationChoiceChoice(LoanBulkServicingNotificationChoiceChoice loanBulkServicingNotificationChoiceChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityDetailsModel"), processor, FacilityDetailsModel.FacilityDetailsModelBuilder.class, getFacilityDetailsModel());
			processRosetta(path.newSubPath("loanBulkServicingNotificationChoiceChoice"), processor, LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder.class, getLoanBulkServicingNotificationChoiceChoice());
		}
		

		LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotificationChoice1  ***********************/
	class LoanBulkServicingNotificationChoice1Impl implements LoanBulkServicingNotificationChoice1 {
		private final FacilityDetailsModel facilityDetailsModel;
		private final LoanBulkServicingNotificationChoiceChoice loanBulkServicingNotificationChoiceChoice;
		
		protected LoanBulkServicingNotificationChoice1Impl(LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder builder) {
			this.facilityDetailsModel = ofNullable(builder.getFacilityDetailsModel()).map(f->f.build()).orElse(null);
			this.loanBulkServicingNotificationChoiceChoice = ofNullable(builder.getLoanBulkServicingNotificationChoiceChoice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoiceChoice")
		public LoanBulkServicingNotificationChoiceChoice getLoanBulkServicingNotificationChoiceChoice() {
			return loanBulkServicingNotificationChoiceChoice;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice1 build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder toBuilder() {
			LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder builder) {
			ofNullable(getFacilityDetailsModel()).ifPresent(builder::setFacilityDetailsModel);
			ofNullable(getLoanBulkServicingNotificationChoiceChoice()).ifPresent(builder::setLoanBulkServicingNotificationChoiceChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(loanBulkServicingNotificationChoiceChoice, _that.getLoanBulkServicingNotificationChoiceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationChoiceChoice != null ? loanBulkServicingNotificationChoiceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoice1 {" +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanBulkServicingNotificationChoiceChoice=" + this.loanBulkServicingNotificationChoiceChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotificationChoice1  ***********************/
	class LoanBulkServicingNotificationChoice1BuilderImpl implements LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder {
	
		protected FacilityDetailsModel.FacilityDetailsModelBuilder facilityDetailsModel;
		protected LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder loanBulkServicingNotificationChoiceChoice;
	
		public LoanBulkServicingNotificationChoice1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public FacilityDetailsModel.FacilityDetailsModelBuilder getFacilityDetailsModel() {
			return facilityDetailsModel;
		}
		
		@Override
		public FacilityDetailsModel.FacilityDetailsModelBuilder getOrCreateFacilityDetailsModel() {
			FacilityDetailsModel.FacilityDetailsModelBuilder result;
			if (facilityDetailsModel!=null) {
				result = facilityDetailsModel;
			}
			else {
				result = facilityDetailsModel = FacilityDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoiceChoice")
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder getLoanBulkServicingNotificationChoiceChoice() {
			return loanBulkServicingNotificationChoiceChoice;
		}
		
		@Override
		public LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder getOrCreateLoanBulkServicingNotificationChoiceChoice() {
			LoanBulkServicingNotificationChoiceChoice.LoanBulkServicingNotificationChoiceChoiceBuilder result;
			if (loanBulkServicingNotificationChoiceChoice!=null) {
				result = loanBulkServicingNotificationChoiceChoice;
			}
			else {
				result = loanBulkServicingNotificationChoiceChoice = LoanBulkServicingNotificationChoiceChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityDetailsModel")
		public LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder setFacilityDetailsModel(FacilityDetailsModel facilityDetailsModel) {
			this.facilityDetailsModel = facilityDetailsModel==null?null:facilityDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanBulkServicingNotificationChoiceChoice")
		public LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder setLoanBulkServicingNotificationChoiceChoice(LoanBulkServicingNotificationChoiceChoice loanBulkServicingNotificationChoiceChoice) {
			this.loanBulkServicingNotificationChoiceChoice = loanBulkServicingNotificationChoiceChoice==null?null:loanBulkServicingNotificationChoiceChoice.toBuilder();
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice1 build() {
			return new LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Impl(this);
		}
		
		@Override
		public LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder prune() {
			if (facilityDetailsModel!=null && !facilityDetailsModel.prune().hasData()) facilityDetailsModel = null;
			if (loanBulkServicingNotificationChoiceChoice!=null && !loanBulkServicingNotificationChoiceChoice.prune().hasData()) loanBulkServicingNotificationChoiceChoice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityDetailsModel()!=null && getFacilityDetailsModel().hasData()) return true;
			if (getLoanBulkServicingNotificationChoiceChoice()!=null && getLoanBulkServicingNotificationChoiceChoice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder o = (LoanBulkServicingNotificationChoice1.LoanBulkServicingNotificationChoice1Builder) other;
			
			merger.mergeRosetta(getFacilityDetailsModel(), o.getFacilityDetailsModel(), this::setFacilityDetailsModel);
			merger.mergeRosetta(getLoanBulkServicingNotificationChoiceChoice(), o.getLoanBulkServicingNotificationChoiceChoice(), this::setLoanBulkServicingNotificationChoiceChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(facilityDetailsModel, _that.getFacilityDetailsModel())) return false;
			if (!Objects.equals(loanBulkServicingNotificationChoiceChoice, _that.getLoanBulkServicingNotificationChoiceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityDetailsModel != null ? facilityDetailsModel.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationChoiceChoice != null ? loanBulkServicingNotificationChoiceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoice1Builder {" +
				"facilityDetailsModel=" + this.facilityDetailsModel + ", " +
				"loanBulkServicingNotificationChoiceChoice=" + this.loanBulkServicingNotificationChoiceChoice +
			'}';
		}
	}
}
