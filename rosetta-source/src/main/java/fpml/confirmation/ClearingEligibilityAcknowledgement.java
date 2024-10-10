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
import fpml.confirmation.Acknowledgement;
import fpml.confirmation.Acknowledgement.AcknowledgementBuilder;
import fpml.confirmation.Acknowledgement.AcknowledgementBuilderImpl;
import fpml.confirmation.Acknowledgement.AcknowledgementImpl;
import fpml.confirmation.ClearingEligibilityAcknowledgement;
import fpml.confirmation.ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder;
import fpml.confirmation.ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilderImpl;
import fpml.confirmation.ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ClearingEligibilityAcknowledgementMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingEligibilityAcknowledgement", builder=ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilderImpl.class, version="${project.version}")
public interface ClearingEligibilityAcknowledgement extends Acknowledgement {

	ClearingEligibilityAcknowledgementMeta metaData = new ClearingEligibilityAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ClearingEligibilityAcknowledgement build();
	
	ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder toBuilder();
	
	static ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder builder() {
		return new ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingEligibilityAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingEligibilityAcknowledgement> getType() {
		return ClearingEligibilityAcknowledgement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingEligibilityAcknowledgementBuilder extends ClearingEligibilityAcknowledgement, Acknowledgement.AcknowledgementBuilder {
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setActualBuild(Integer actualBuild);
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingEligibilityAcknowledgement  ***********************/
	class ClearingEligibilityAcknowledgementImpl extends Acknowledgement.AcknowledgementImpl implements ClearingEligibilityAcknowledgement {
		
		protected ClearingEligibilityAcknowledgementImpl(ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ClearingEligibilityAcknowledgement build() {
			return this;
		}
		
		@Override
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder toBuilder() {
			ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingEligibilityAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingEligibilityAcknowledgement  ***********************/
	class ClearingEligibilityAcknowledgementBuilderImpl extends Acknowledgement.AcknowledgementBuilderImpl  implements ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder {
	
	
		public ClearingEligibilityAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ClearingEligibilityAcknowledgement build() {
			return new ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementImpl(this);
		}
		
		@Override
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder o = (ClearingEligibilityAcknowledgement.ClearingEligibilityAcknowledgementBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingEligibilityAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
