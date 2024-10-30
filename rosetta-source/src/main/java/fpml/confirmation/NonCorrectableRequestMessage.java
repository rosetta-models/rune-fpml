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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessage;
import fpml.confirmation.RequestMessage.RequestMessageBuilder;
import fpml.confirmation.RequestMessage.RequestMessageBuilderImpl;
import fpml.confirmation.RequestMessage.RequestMessageImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.NonCorrectableRequestMessageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the content model for a request message that cannot be subsequently corrected or retracted.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NonCorrectableRequestMessage", builder=NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NonCorrectableRequestMessage extends RequestMessage {

	NonCorrectableRequestMessageMeta metaData = new NonCorrectableRequestMessageMeta();

	/*********************** Getter Methods  ***********************/
	CorrelationAndSequenceModel getCorrelationAndSequenceModel();
	OnBehalfOfModel getOnBehalfOfModel();

	/*********************** Build Methods  ***********************/
	NonCorrectableRequestMessage build();
	
	NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder toBuilder();
	
	static NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder() {
		return new NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonCorrectableRequestMessage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonCorrectableRequestMessage> getType() {
		return NonCorrectableRequestMessage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonCorrectableRequestMessageBuilder extends NonCorrectableRequestMessage, RequestMessage.RequestMessageBuilder {
		CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder getOrCreateCorrelationAndSequenceModel();
		CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder getCorrelationAndSequenceModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOrCreateOnBehalfOfModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOnBehalfOfModel();
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setExpectedBuild(Integer expectedBuild);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setActualBuild(Integer actualBuild);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setHeader(RequestMessageHeader header);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setValidationModel(ValidationModel validationModel);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
		}
		

		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder prune();
	}

	/*********************** Immutable Implementation of NonCorrectableRequestMessage  ***********************/
	class NonCorrectableRequestMessageImpl extends RequestMessage.RequestMessageImpl implements NonCorrectableRequestMessage {
		private final CorrelationAndSequenceModel correlationAndSequenceModel;
		private final OnBehalfOfModel onBehalfOfModel;
		
		protected NonCorrectableRequestMessageImpl(NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder) {
			super(builder);
			this.correlationAndSequenceModel = ofNullable(builder.getCorrelationAndSequenceModel()).map(f->f.build()).orElse(null);
			this.onBehalfOfModel = ofNullable(builder.getOnBehalfOfModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public CorrelationAndSequenceModel getCorrelationAndSequenceModel() {
			return correlationAndSequenceModel;
		}
		
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public OnBehalfOfModel getOnBehalfOfModel() {
			return onBehalfOfModel;
		}
		
		@Override
		public NonCorrectableRequestMessage build() {
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder toBuilder() {
			NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCorrelationAndSequenceModel()).ifPresent(builder::setCorrelationAndSequenceModel);
			ofNullable(getOnBehalfOfModel()).ifPresent(builder::setOnBehalfOfModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonCorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(correlationAndSequenceModel, _that.getCorrelationAndSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationAndSequenceModel != null ? correlationAndSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonCorrectableRequestMessage {" +
				"correlationAndSequenceModel=" + this.correlationAndSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonCorrectableRequestMessage  ***********************/
	class NonCorrectableRequestMessageBuilderImpl extends RequestMessage.RequestMessageBuilderImpl  implements NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
	
		protected CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder correlationAndSequenceModel;
		protected OnBehalfOfModel.OnBehalfOfModelBuilder onBehalfOfModel;
	
		public NonCorrectableRequestMessageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder getCorrelationAndSequenceModel() {
			return correlationAndSequenceModel;
		}
		
		@Override
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder getOrCreateCorrelationAndSequenceModel() {
			CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder result;
			if (correlationAndSequenceModel!=null) {
				result = correlationAndSequenceModel;
			}
			else {
				result = correlationAndSequenceModel = CorrelationAndSequenceModel.builder();
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
		@RosettaAttribute("expectedBuild")
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage build() {
			return new NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl(this);
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder prune() {
			super.prune();
			if (correlationAndSequenceModel!=null && !correlationAndSequenceModel.prune().hasData()) correlationAndSequenceModel = null;
			if (onBehalfOfModel!=null && !onBehalfOfModel.prune().hasData()) onBehalfOfModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCorrelationAndSequenceModel()!=null && getCorrelationAndSequenceModel().hasData()) return true;
			if (getOnBehalfOfModel()!=null && getOnBehalfOfModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder o = (NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder) other;
			
			merger.mergeRosetta(getCorrelationAndSequenceModel(), o.getCorrelationAndSequenceModel(), this::setCorrelationAndSequenceModel);
			merger.mergeRosetta(getOnBehalfOfModel(), o.getOnBehalfOfModel(), this::setOnBehalfOfModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonCorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(correlationAndSequenceModel, _that.getCorrelationAndSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationAndSequenceModel != null ? correlationAndSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonCorrectableRequestMessageBuilder {" +
				"correlationAndSequenceModel=" + this.correlationAndSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}
}
