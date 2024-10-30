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
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.VerificationStatusAcknowledgement;
import fpml.confirmation.VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder;
import fpml.confirmation.VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilderImpl;
import fpml.confirmation.VerificationStatusAcknowledgement.VerificationStatusAcknowledgementImpl;
import fpml.confirmation.meta.VerificationStatusAcknowledgementMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="VerificationStatusAcknowledgement", builder=VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface VerificationStatusAcknowledgement extends Acknowledgement {

	VerificationStatusAcknowledgementMeta metaData = new VerificationStatusAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	VerificationStatusAcknowledgement build();
	
	VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder toBuilder();
	
	static VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder builder() {
		return new VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VerificationStatusAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VerificationStatusAcknowledgement> getType() {
		return VerificationStatusAcknowledgement.class;
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
	interface VerificationStatusAcknowledgementBuilder extends VerificationStatusAcknowledgement, Acknowledgement.AcknowledgementBuilder {
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setActualBuild(Integer actualBuild);
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of VerificationStatusAcknowledgement  ***********************/
	class VerificationStatusAcknowledgementImpl extends Acknowledgement.AcknowledgementImpl implements VerificationStatusAcknowledgement {
		
		protected VerificationStatusAcknowledgementImpl(VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public VerificationStatusAcknowledgement build() {
			return this;
		}
		
		@Override
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder toBuilder() {
			VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder builder) {
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
			return "VerificationStatusAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VerificationStatusAcknowledgement  ***********************/
	class VerificationStatusAcknowledgementBuilderImpl extends Acknowledgement.AcknowledgementBuilderImpl  implements VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder {
	
	
		public VerificationStatusAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public VerificationStatusAcknowledgement build() {
			return new VerificationStatusAcknowledgement.VerificationStatusAcknowledgementImpl(this);
		}
		
		@Override
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder prune() {
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
		public VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder o = (VerificationStatusAcknowledgement.VerificationStatusAcknowledgementBuilder) other;
			
			
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
			return "VerificationStatusAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
