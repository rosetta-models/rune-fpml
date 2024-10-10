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
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.LoanAcknowledgement;
import fpml.confirmation.LoanAcknowledgement.LoanAcknowledgementBuilder;
import fpml.confirmation.LoanAcknowledgement.LoanAcknowledgementBuilderImpl;
import fpml.confirmation.LoanAcknowledgement.LoanAcknowledgementImpl;
import fpml.confirmation.Message;
import fpml.confirmation.Message.MessageBuilder;
import fpml.confirmation.Message.MessageBuilderImpl;
import fpml.confirmation.Message.MessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanAcknowledgementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A base type to extend the FpML basic &#39;message&#39; type, similar in function to the &#39;response&#39; message, but specific to the needs loan asset class.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAcknowledgement", builder=LoanAcknowledgement.LoanAcknowledgementBuilderImpl.class, version="${project.version}")
public interface LoanAcknowledgement extends Message {

	LoanAcknowledgementMeta metaData = new LoanAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/
	ResponseMessageHeader getHeader();
	ValidationModel getValidationModel();
	CorrelationAndOptionalSequenceModel getCorrelationAndOptionalSequenceModel();
	OnBehalfOfModel getOnBehalfOfModel();
	UnprocessedElementWrapper getOriginalMessage();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	LoanAcknowledgement build();
	
	LoanAcknowledgement.LoanAcknowledgementBuilder toBuilder();
	
	static LoanAcknowledgement.LoanAcknowledgementBuilder builder() {
		return new LoanAcknowledgement.LoanAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAcknowledgement> getType() {
		return LoanAcknowledgement.class;
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
	interface LoanAcknowledgementBuilder extends LoanAcknowledgement, Message.MessageBuilder {
		ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader();
		ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader();
		ValidationModel.ValidationModelBuilder getOrCreateValidationModel();
		ValidationModel.ValidationModelBuilder getValidationModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getOrCreateCorrelationAndOptionalSequenceModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getCorrelationAndOptionalSequenceModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOrCreateOnBehalfOfModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOnBehalfOfModel();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		LoanAcknowledgement.LoanAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		LoanAcknowledgement.LoanAcknowledgementBuilder setActualBuild(Integer actualBuild);
		LoanAcknowledgement.LoanAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		LoanAcknowledgement.LoanAcknowledgementBuilder setValidationModel(ValidationModel validationModel);
		LoanAcknowledgement.LoanAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		LoanAcknowledgement.LoanAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanAcknowledgement.LoanAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		LoanAcknowledgement.LoanAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		LoanAcknowledgement.LoanAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAcknowledgement  ***********************/
	class LoanAcknowledgementImpl extends Message.MessageImpl implements LoanAcknowledgement {
		private final ResponseMessageHeader header;
		private final ValidationModel validationModel;
		private final CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel;
		private final OnBehalfOfModel onBehalfOfModel;
		private final UnprocessedElementWrapper originalMessage;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected LoanAcknowledgementImpl(LoanAcknowledgement.LoanAcknowledgementBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validationModel = ofNullable(builder.getValidationModel()).map(f->f.build()).orElse(null);
			this.correlationAndOptionalSequenceModel = ofNullable(builder.getCorrelationAndOptionalSequenceModel()).map(f->f.build()).orElse(null);
			this.onBehalfOfModel = ofNullable(builder.getOnBehalfOfModel()).map(f->f.build()).orElse(null);
			this.originalMessage = ofNullable(builder.getOriginalMessage()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		public ResponseMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("validationModel")
		public ValidationModel getValidationModel() {
			return validationModel;
		}
		
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CorrelationAndOptionalSequenceModel getCorrelationAndOptionalSequenceModel() {
			return correlationAndOptionalSequenceModel;
		}
		
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public OnBehalfOfModel getOnBehalfOfModel() {
			return onBehalfOfModel;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		public UnprocessedElementWrapper getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public LoanAcknowledgement build() {
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder toBuilder() {
			LoanAcknowledgement.LoanAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAcknowledgement.LoanAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidationModel()).ifPresent(builder::setValidationModel);
			ofNullable(getCorrelationAndOptionalSequenceModel()).ifPresent(builder::setCorrelationAndOptionalSequenceModel);
			ofNullable(getOnBehalfOfModel()).ifPresent(builder::setOnBehalfOfModel);
			ofNullable(getOriginalMessage()).ifPresent(builder::setOriginalMessage);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(correlationAndOptionalSequenceModel, _that.getCorrelationAndOptionalSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (correlationAndOptionalSequenceModel != null ? correlationAndOptionalSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAcknowledgement {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel + ", " +
				"originalMessage=" + this.originalMessage + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAcknowledgement  ***********************/
	class LoanAcknowledgementBuilderImpl extends Message.MessageBuilderImpl  implements LoanAcknowledgement.LoanAcknowledgementBuilder {
	
		protected ResponseMessageHeader.ResponseMessageHeaderBuilder header;
		protected ValidationModel.ValidationModelBuilder validationModel;
		protected CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder correlationAndOptionalSequenceModel;
		protected OnBehalfOfModel.OnBehalfOfModelBuilder onBehalfOfModel;
		protected UnprocessedElementWrapper.UnprocessedElementWrapperBuilder originalMessage;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public LoanAcknowledgementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("header")
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader() {
			ResponseMessageHeader.ResponseMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ResponseMessageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("validationModel")
		public ValidationModel.ValidationModelBuilder getValidationModel() {
			return validationModel;
		}
		
		@Override
		public ValidationModel.ValidationModelBuilder getOrCreateValidationModel() {
			ValidationModel.ValidationModelBuilder result;
			if (validationModel!=null) {
				result = validationModel;
			}
			else {
				result = validationModel = ValidationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getCorrelationAndOptionalSequenceModel() {
			return correlationAndOptionalSequenceModel;
		}
		
		@Override
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder getOrCreateCorrelationAndOptionalSequenceModel() {
			CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder result;
			if (correlationAndOptionalSequenceModel!=null) {
				result = correlationAndOptionalSequenceModel;
			}
			else {
				result = correlationAndOptionalSequenceModel = CorrelationAndOptionalSequenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public OnBehalfOfModel.OnBehalfOfModelBuilder getOnBehalfOfModel() {
			return onBehalfOfModel;
		}
		
		@Override
		public OnBehalfOfModel.OnBehalfOfModelBuilder getOrCreateOnBehalfOfModel() {
			OnBehalfOfModel.OnBehalfOfModelBuilder result;
			if (onBehalfOfModel!=null) {
				result = onBehalfOfModel;
			}
			else {
				result = onBehalfOfModel = OnBehalfOfModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder result;
			if (originalMessage!=null) {
				result = originalMessage;
			}
			else {
				result = originalMessage = UnprocessedElementWrapper.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder result;
			if (partiesAndAccountsModel!=null) {
				result = partiesAndAccountsModel;
			}
			else {
				result = partiesAndAccountsModel = PartiesAndAccountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalMessage")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage) {
			this.originalMessage = originalMessage==null?null:originalMessage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public LoanAcknowledgement.LoanAcknowledgementBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanAcknowledgement build() {
			return new LoanAcknowledgement.LoanAcknowledgementImpl(this);
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			if (validationModel!=null && !validationModel.prune().hasData()) validationModel = null;
			if (correlationAndOptionalSequenceModel!=null && !correlationAndOptionalSequenceModel.prune().hasData()) correlationAndOptionalSequenceModel = null;
			if (onBehalfOfModel!=null && !onBehalfOfModel.prune().hasData()) onBehalfOfModel = null;
			if (originalMessage!=null && !originalMessage.prune().hasData()) originalMessage = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getValidationModel()!=null && getValidationModel().hasData()) return true;
			if (getCorrelationAndOptionalSequenceModel()!=null && getCorrelationAndOptionalSequenceModel().hasData()) return true;
			if (getOnBehalfOfModel()!=null && getOnBehalfOfModel().hasData()) return true;
			if (getOriginalMessage()!=null && getOriginalMessage().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAcknowledgement.LoanAcknowledgementBuilder o = (LoanAcknowledgement.LoanAcknowledgementBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidationModel(), o.getValidationModel(), this::setValidationModel);
			merger.mergeRosetta(getCorrelationAndOptionalSequenceModel(), o.getCorrelationAndOptionalSequenceModel(), this::setCorrelationAndOptionalSequenceModel);
			merger.mergeRosetta(getOnBehalfOfModel(), o.getOnBehalfOfModel(), this::setOnBehalfOfModel);
			merger.mergeRosetta(getOriginalMessage(), o.getOriginalMessage(), this::setOriginalMessage);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(validationModel, _that.getValidationModel())) return false;
			if (!Objects.equals(correlationAndOptionalSequenceModel, _that.getCorrelationAndOptionalSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validationModel != null ? validationModel.hashCode() : 0);
			_result = 31 * _result + (correlationAndOptionalSequenceModel != null ? correlationAndOptionalSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAcknowledgementBuilder {" +
				"header=" + this.header + ", " +
				"validationModel=" + this.validationModel + ", " +
				"correlationAndOptionalSequenceModel=" + this.correlationAndOptionalSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel + ", " +
				"originalMessage=" + this.originalMessage + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
