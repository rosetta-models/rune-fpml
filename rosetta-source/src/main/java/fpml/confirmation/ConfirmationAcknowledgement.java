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
import fpml.confirmation.ConfirmationAcknowledgement;
import fpml.confirmation.ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder;
import fpml.confirmation.ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilderImpl;
import fpml.confirmation.ConfirmationAcknowledgement.ConfirmationAcknowledgementImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.EventRequestAcknowledgement;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementBuilder;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl;
import fpml.confirmation.EventRequestAcknowledgement.EventRequestAcknowledgementImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ConfirmationAcknowledgementMeta;


/**
 * A business acknowledgement message to indicate that the previously sent message was sucessfully processed.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ConfirmationAcknowledgement", builder=ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ConfirmationAcknowledgement extends EventRequestAcknowledgement {

	ConfirmationAcknowledgementMeta metaData = new ConfirmationAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ConfirmationAcknowledgement build();
	
	ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder toBuilder();
	
	static ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder builder() {
		return new ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConfirmationAcknowledgement> getType() {
		return ConfirmationAcknowledgement.class;
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
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConfirmationAcknowledgementBuilder extends ConfirmationAcknowledgement, EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setActualBuild(Integer actualBuild);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationAcknowledgement  ***********************/
	class ConfirmationAcknowledgementImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementImpl implements ConfirmationAcknowledgement {
		
		protected ConfirmationAcknowledgementImpl(ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ConfirmationAcknowledgement build() {
			return this;
		}
		
		@Override
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder toBuilder() {
			ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder builder) {
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
			return "ConfirmationAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConfirmationAcknowledgement  ***********************/
	class ConfirmationAcknowledgementBuilderImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl  implements ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder {
	
	
		public ConfirmationAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ConfirmationAcknowledgement build() {
			return new ConfirmationAcknowledgement.ConfirmationAcknowledgementImpl(this);
		}
		
		@Override
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder prune() {
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
		public ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder o = (ConfirmationAcknowledgement.ConfirmationAcknowledgementBuilder) other;
			
			
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
			return "ConfirmationAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
