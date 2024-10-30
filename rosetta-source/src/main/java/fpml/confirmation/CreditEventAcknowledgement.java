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
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.CreditEventAcknowledgement;
import fpml.confirmation.CreditEventAcknowledgement.CreditEventAcknowledgementBuilder;
import fpml.confirmation.CreditEventAcknowledgement.CreditEventAcknowledgementBuilderImpl;
import fpml.confirmation.CreditEventAcknowledgement.CreditEventAcknowledgementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.CreditEventAcknowledgementMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditEventAcknowledgement", builder=CreditEventAcknowledgement.CreditEventAcknowledgementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditEventAcknowledgement extends Acknowledgement {

	CreditEventAcknowledgementMeta metaData = new CreditEventAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CreditEventAcknowledgement build();
	
	CreditEventAcknowledgement.CreditEventAcknowledgementBuilder toBuilder();
	
	static CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder() {
		return new CreditEventAcknowledgement.CreditEventAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEventAcknowledgement> getType() {
		return CreditEventAcknowledgement.class;
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
	interface CreditEventAcknowledgementBuilder extends CreditEventAcknowledgement, Acknowledgement.AcknowledgementBuilder {
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setActualBuild(Integer actualBuild);
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventAcknowledgement  ***********************/
	class CreditEventAcknowledgementImpl extends Acknowledgement.AcknowledgementImpl implements CreditEventAcknowledgement {
		
		protected CreditEventAcknowledgementImpl(CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public CreditEventAcknowledgement build() {
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder toBuilder() {
			CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
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
			return "CreditEventAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventAcknowledgement  ***********************/
	class CreditEventAcknowledgementBuilderImpl extends Acknowledgement.AcknowledgementBuilderImpl  implements CreditEventAcknowledgement.CreditEventAcknowledgementBuilder {
	
	
		public CreditEventAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement build() {
			return new CreditEventAcknowledgement.CreditEventAcknowledgementImpl(this);
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder prune() {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditEventAcknowledgement.CreditEventAcknowledgementBuilder o = (CreditEventAcknowledgement.CreditEventAcknowledgementBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
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
			return "CreditEventAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
