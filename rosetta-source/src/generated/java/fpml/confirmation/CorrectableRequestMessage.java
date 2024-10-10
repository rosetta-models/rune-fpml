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
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessage;
import fpml.confirmation.RequestMessage.RequestMessageBuilder;
import fpml.confirmation.RequestMessage.RequestMessageBuilderImpl;
import fpml.confirmation.RequestMessage.RequestMessageImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.CorrectableRequestMessageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the content model for a request message that can be subsequently corrected or retracted.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrectableRequestMessage", builder=CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl.class, version="${project.version}")
public interface CorrectableRequestMessage extends RequestMessage {

	CorrectableRequestMessageMeta metaData = new CorrectableRequestMessageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates if this message corrects an earlier request.
	 */
	Boolean getIsCorrection();
	CorrelationAndSequenceModel getCorrelationAndSequenceModel();
	OnBehalfOfModel getOnBehalfOfModel();

	/*********************** Build Methods  ***********************/
	CorrectableRequestMessage build();
	
	CorrectableRequestMessage.CorrectableRequestMessageBuilder toBuilder();
	
	static CorrectableRequestMessage.CorrectableRequestMessageBuilder builder() {
		return new CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrectableRequestMessage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrectableRequestMessage> getType() {
		return CorrectableRequestMessage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrectableRequestMessageBuilder extends CorrectableRequestMessage, RequestMessage.RequestMessageBuilder {
		CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder getOrCreateCorrelationAndSequenceModel();
		CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder getCorrelationAndSequenceModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOrCreateOnBehalfOfModel();
		OnBehalfOfModel.OnBehalfOfModelBuilder getOnBehalfOfModel();
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setExpectedBuild(Integer expectedBuild);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setActualBuild(Integer actualBuild);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setHeader(RequestMessageHeader header);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setValidationModel(ValidationModel validationModel);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setIsCorrection(Boolean isCorrection);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
		}
		

		CorrectableRequestMessage.CorrectableRequestMessageBuilder prune();
	}

	/*********************** Immutable Implementation of CorrectableRequestMessage  ***********************/
	class CorrectableRequestMessageImpl extends RequestMessage.RequestMessageImpl implements CorrectableRequestMessage {
		private final Boolean isCorrection;
		private final CorrelationAndSequenceModel correlationAndSequenceModel;
		private final OnBehalfOfModel onBehalfOfModel;
		
		protected CorrectableRequestMessageImpl(CorrectableRequestMessage.CorrectableRequestMessageBuilder builder) {
			super(builder);
			this.isCorrection = builder.getIsCorrection();
			this.correlationAndSequenceModel = ofNullable(builder.getCorrelationAndSequenceModel()).map(f->f.build()).orElse(null);
			this.onBehalfOfModel = ofNullable(builder.getOnBehalfOfModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isCorrection")
		public Boolean getIsCorrection() {
			return isCorrection;
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
		public CorrectableRequestMessage build() {
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder toBuilder() {
			CorrectableRequestMessage.CorrectableRequestMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrectableRequestMessage.CorrectableRequestMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIsCorrection()).ifPresent(builder::setIsCorrection);
			ofNullable(getCorrelationAndSequenceModel()).ifPresent(builder::setCorrelationAndSequenceModel);
			ofNullable(getOnBehalfOfModel()).ifPresent(builder::setOnBehalfOfModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(isCorrection, _that.getIsCorrection())) return false;
			if (!Objects.equals(correlationAndSequenceModel, _that.getCorrelationAndSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCorrection != null ? isCorrection.hashCode() : 0);
			_result = 31 * _result + (correlationAndSequenceModel != null ? correlationAndSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrectableRequestMessage {" +
				"isCorrection=" + this.isCorrection + ", " +
				"correlationAndSequenceModel=" + this.correlationAndSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrectableRequestMessage  ***********************/
	class CorrectableRequestMessageBuilderImpl extends RequestMessage.RequestMessageBuilderImpl  implements CorrectableRequestMessage.CorrectableRequestMessageBuilder {
	
		protected Boolean isCorrection;
		protected CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder correlationAndSequenceModel;
		protected OnBehalfOfModel.OnBehalfOfModelBuilder onBehalfOfModel;
	
		public CorrectableRequestMessageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("isCorrection")
		public Boolean getIsCorrection() {
			return isCorrection;
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
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		
		@Override
		public CorrectableRequestMessage build() {
			return new CorrectableRequestMessage.CorrectableRequestMessageImpl(this);
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder prune() {
			super.prune();
			if (correlationAndSequenceModel!=null && !correlationAndSequenceModel.prune().hasData()) correlationAndSequenceModel = null;
			if (onBehalfOfModel!=null && !onBehalfOfModel.prune().hasData()) onBehalfOfModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIsCorrection()!=null) return true;
			if (getCorrelationAndSequenceModel()!=null && getCorrelationAndSequenceModel().hasData()) return true;
			if (getOnBehalfOfModel()!=null && getOnBehalfOfModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CorrectableRequestMessage.CorrectableRequestMessageBuilder o = (CorrectableRequestMessage.CorrectableRequestMessageBuilder) other;
			
			merger.mergeRosetta(getCorrelationAndSequenceModel(), o.getCorrelationAndSequenceModel(), this::setCorrelationAndSequenceModel);
			merger.mergeRosetta(getOnBehalfOfModel(), o.getOnBehalfOfModel(), this::setOnBehalfOfModel);
			
			merger.mergeBasic(getIsCorrection(), o.getIsCorrection(), this::setIsCorrection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(isCorrection, _that.getIsCorrection())) return false;
			if (!Objects.equals(correlationAndSequenceModel, _that.getCorrelationAndSequenceModel())) return false;
			if (!Objects.equals(onBehalfOfModel, _that.getOnBehalfOfModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCorrection != null ? isCorrection.hashCode() : 0);
			_result = 31 * _result + (correlationAndSequenceModel != null ? correlationAndSequenceModel.hashCode() : 0);
			_result = 31 * _result + (onBehalfOfModel != null ? onBehalfOfModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrectableRequestMessageBuilder {" +
				"isCorrection=" + this.isCorrection + ", " +
				"correlationAndSequenceModel=" + this.correlationAndSequenceModel + ", " +
				"onBehalfOfModel=" + this.onBehalfOfModel +
			'}' + " " + super.toString();
		}
	}
}
