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
import fpml.confirmation.AbstractLoanPartyProfileNotification;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractLoanPartyProfileNotificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type for all supplementary communication to paying entities and/or servicing platforms.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanPartyProfileNotification", builder=AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl.class, version="${project.version}")
public interface AbstractLoanPartyProfileNotification extends CorrectableRequestMessage {

	AbstractLoanPartyProfileNotificationMeta metaData = new AbstractLoanPartyProfileNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A free-form, manually entered field which will be used by users directly for additional information.
	 */
	String getComments();

	/*********************** Build Methods  ***********************/
	AbstractLoanPartyProfileNotification build();
	
	AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder toBuilder();
	
	static AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder builder() {
		return new AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanPartyProfileNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanPartyProfileNotification> getType() {
		return AbstractLoanPartyProfileNotification.class;
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
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanPartyProfileNotificationBuilder extends AbstractLoanPartyProfileNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setActualBuild(Integer actualBuild);
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setHeader(RequestMessageHeader header);
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setValidationModel(ValidationModel validationModel);
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setIsCorrection(Boolean isCorrection);
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setComments(String comments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		}
		

		AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanPartyProfileNotification  ***********************/
	class AbstractLoanPartyProfileNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractLoanPartyProfileNotification {
		private final String comments;
		
		protected AbstractLoanPartyProfileNotificationImpl(AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder builder) {
			super(builder);
			this.comments = builder.getComments();
		}
		
		@Override
		@RosettaAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		public AbstractLoanPartyProfileNotification build() {
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder toBuilder() {
			AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getComments()).ifPresent(builder::setComments);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanPartyProfileNotification _that = getType().cast(o);
		
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanPartyProfileNotification {" +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanPartyProfileNotification  ***********************/
	class AbstractLoanPartyProfileNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder {
	
		protected String comments;
	
		public AbstractLoanPartyProfileNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileNotification build() {
			return new AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl(this);
		}
		
		@Override
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getComments()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder o = (AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder) other;
			
			
			merger.mergeBasic(getComments(), o.getComments(), this::setComments);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanPartyProfileNotification _that = getType().cast(o);
		
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanPartyProfileNotificationBuilder {" +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}
}
