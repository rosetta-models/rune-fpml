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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractLoanStatement;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementBuilder;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementBuilderImpl;
import fpml.confirmation.AbstractLoanStatement.AbstractLoanStatementImpl;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractLoanStatementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type for all syndicated loan statement notifications; the wrapper for deal/facility/contract definitions and facility/contract positions at a particular point in time (snapshot).
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanStatement", builder=AbstractLoanStatement.AbstractLoanStatementBuilderImpl.class, version="${project.version}")
public interface AbstractLoanStatement extends CorrectableRequestMessage {

	AbstractLoanStatementMeta metaData = new AbstractLoanStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date as of which the embedded information is valid.
	 */
	Date getStatementDate();
	/**
	 * A free-form, manually entered field which will be used by users directly for additional information.
	 */
	String getComments();

	/*********************** Build Methods  ***********************/
	AbstractLoanStatement build();
	
	AbstractLoanStatement.AbstractLoanStatementBuilder toBuilder();
	
	static AbstractLoanStatement.AbstractLoanStatementBuilder builder() {
		return new AbstractLoanStatement.AbstractLoanStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanStatement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanStatement> getType() {
		return AbstractLoanStatement.class;
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
		processor.processBasic(path.newSubPath("statementDate"), Date.class, getStatementDate(), this);
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanStatementBuilder extends AbstractLoanStatement, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		AbstractLoanStatement.AbstractLoanStatementBuilder setExpectedBuild(Integer expectedBuild);
		AbstractLoanStatement.AbstractLoanStatementBuilder setActualBuild(Integer actualBuild);
		AbstractLoanStatement.AbstractLoanStatementBuilder setHeader(RequestMessageHeader header);
		AbstractLoanStatement.AbstractLoanStatementBuilder setValidationModel(ValidationModel validationModel);
		AbstractLoanStatement.AbstractLoanStatementBuilder setIsCorrection(Boolean isCorrection);
		AbstractLoanStatement.AbstractLoanStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractLoanStatement.AbstractLoanStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractLoanStatement.AbstractLoanStatementBuilder setStatementDate(Date statementDate);
		AbstractLoanStatement.AbstractLoanStatementBuilder setComments(String comments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("statementDate"), Date.class, getStatementDate(), this);
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		}
		

		AbstractLoanStatement.AbstractLoanStatementBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanStatement  ***********************/
	class AbstractLoanStatementImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractLoanStatement {
		private final Date statementDate;
		private final String comments;
		
		protected AbstractLoanStatementImpl(AbstractLoanStatement.AbstractLoanStatementBuilder builder) {
			super(builder);
			this.statementDate = builder.getStatementDate();
			this.comments = builder.getComments();
		}
		
		@Override
		@RosettaAttribute("statementDate")
		public Date getStatementDate() {
			return statementDate;
		}
		
		@Override
		@RosettaAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		public AbstractLoanStatement build() {
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder toBuilder() {
			AbstractLoanStatement.AbstractLoanStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanStatement.AbstractLoanStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStatementDate()).ifPresent(builder::setStatementDate);
			ofNullable(getComments()).ifPresent(builder::setComments);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanStatement _that = getType().cast(o);
		
			if (!Objects.equals(statementDate, _that.getStatementDate())) return false;
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (statementDate != null ? statementDate.hashCode() : 0);
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanStatement {" +
				"statementDate=" + this.statementDate + ", " +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanStatement  ***********************/
	class AbstractLoanStatementBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements AbstractLoanStatement.AbstractLoanStatementBuilder {
	
		protected Date statementDate;
		protected String comments;
	
		public AbstractLoanStatementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("statementDate")
		public Date getStatementDate() {
			return statementDate;
		}
		
		@Override
		@RosettaAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("statementDate")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setStatementDate(Date statementDate) {
			this.statementDate = statementDate==null?null:statementDate;
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public AbstractLoanStatement.AbstractLoanStatementBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		
		@Override
		public AbstractLoanStatement build() {
			return new AbstractLoanStatement.AbstractLoanStatementImpl(this);
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStatementDate()!=null) return true;
			if (getComments()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanStatement.AbstractLoanStatementBuilder o = (AbstractLoanStatement.AbstractLoanStatementBuilder) other;
			
			
			merger.mergeBasic(getStatementDate(), o.getStatementDate(), this::setStatementDate);
			merger.mergeBasic(getComments(), o.getComments(), this::setComments);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanStatement _that = getType().cast(o);
		
			if (!Objects.equals(statementDate, _that.getStatementDate())) return false;
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (statementDate != null ? statementDate.hashCode() : 0);
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanStatementBuilder {" +
				"statementDate=" + this.statementDate + ", " +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}
}
