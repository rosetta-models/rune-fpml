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
import fpml.confirmation.Exception;
import fpml.confirmation.Exception.ExceptionBuilder;
import fpml.confirmation.Exception.ExceptionBuilderImpl;
import fpml.confirmation.Exception.ExceptionImpl;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.LoanNotificationException;
import fpml.confirmation.LoanNotificationException.LoanNotificationExceptionBuilder;
import fpml.confirmation.LoanNotificationException.LoanNotificationExceptionBuilderImpl;
import fpml.confirmation.LoanNotificationException.LoanNotificationExceptionImpl;
import fpml.confirmation.LoanNotificationExceptionSequence;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanNotificationExceptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message used to indicate an exception issue with a loan notification.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanNotificationException", builder=LoanNotificationException.LoanNotificationExceptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanNotificationException extends Exception {

	LoanNotificationExceptionMeta metaData = new LoanNotificationExceptionMeta();

	/*********************** Getter Methods  ***********************/
	LoanNotificationExceptionSequence getLoanNotificationExceptionSequence();

	/*********************** Build Methods  ***********************/
	LoanNotificationException build();
	
	LoanNotificationException.LoanNotificationExceptionBuilder toBuilder();
	
	static LoanNotificationException.LoanNotificationExceptionBuilder builder() {
		return new LoanNotificationException.LoanNotificationExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanNotificationException> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanNotificationException> getType() {
		return LoanNotificationException.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.class, getExceptionModel());
		processRosetta(path.newSubPath("loanNotificationExceptionSequence"), processor, LoanNotificationExceptionSequence.class, getLoanNotificationExceptionSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanNotificationExceptionBuilder extends LoanNotificationException, Exception.ExceptionBuilder {
		LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder getOrCreateLoanNotificationExceptionSequence();
		LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder getLoanNotificationExceptionSequence();
		LoanNotificationException.LoanNotificationExceptionBuilder setExpectedBuild(Integer expectedBuild);
		LoanNotificationException.LoanNotificationExceptionBuilder setActualBuild(Integer actualBuild);
		LoanNotificationException.LoanNotificationExceptionBuilder setHeader(ExceptionMessageHeader header);
		LoanNotificationException.LoanNotificationExceptionBuilder setValidationModel(ValidationModel validationModel);
		LoanNotificationException.LoanNotificationExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		LoanNotificationException.LoanNotificationExceptionBuilder setExceptionModel(ExceptionModel exceptionModel);
		LoanNotificationException.LoanNotificationExceptionBuilder setLoanNotificationExceptionSequence(LoanNotificationExceptionSequence loanNotificationExceptionSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("exceptionModel"), processor, ExceptionModel.ExceptionModelBuilder.class, getExceptionModel());
			processRosetta(path.newSubPath("loanNotificationExceptionSequence"), processor, LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder.class, getLoanNotificationExceptionSequence());
		}
		

		LoanNotificationException.LoanNotificationExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of LoanNotificationException  ***********************/
	class LoanNotificationExceptionImpl extends Exception.ExceptionImpl implements LoanNotificationException {
		private final LoanNotificationExceptionSequence loanNotificationExceptionSequence;
		
		protected LoanNotificationExceptionImpl(LoanNotificationException.LoanNotificationExceptionBuilder builder) {
			super(builder);
			this.loanNotificationExceptionSequence = ofNullable(builder.getLoanNotificationExceptionSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanNotificationExceptionSequence")
		public LoanNotificationExceptionSequence getLoanNotificationExceptionSequence() {
			return loanNotificationExceptionSequence;
		}
		
		@Override
		public LoanNotificationException build() {
			return this;
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder toBuilder() {
			LoanNotificationException.LoanNotificationExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanNotificationException.LoanNotificationExceptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanNotificationExceptionSequence()).ifPresent(builder::setLoanNotificationExceptionSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationException _that = getType().cast(o);
		
			if (!Objects.equals(loanNotificationExceptionSequence, _that.getLoanNotificationExceptionSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanNotificationExceptionSequence != null ? loanNotificationExceptionSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationException {" +
				"loanNotificationExceptionSequence=" + this.loanNotificationExceptionSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanNotificationException  ***********************/
	class LoanNotificationExceptionBuilderImpl extends Exception.ExceptionBuilderImpl  implements LoanNotificationException.LoanNotificationExceptionBuilder {
	
		protected LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder loanNotificationExceptionSequence;
	
		public LoanNotificationExceptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanNotificationExceptionSequence")
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder getLoanNotificationExceptionSequence() {
			return loanNotificationExceptionSequence;
		}
		
		@Override
		public LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder getOrCreateLoanNotificationExceptionSequence() {
			LoanNotificationExceptionSequence.LoanNotificationExceptionSequenceBuilder result;
			if (loanNotificationExceptionSequence!=null) {
				result = loanNotificationExceptionSequence;
			}
			else {
				result = loanNotificationExceptionSequence = LoanNotificationExceptionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public LoanNotificationException.LoanNotificationExceptionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanNotificationException.LoanNotificationExceptionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanNotificationException.LoanNotificationExceptionBuilder setHeader(ExceptionMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanNotificationException.LoanNotificationExceptionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public LoanNotificationException.LoanNotificationExceptionBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exceptionModel")
		public LoanNotificationException.LoanNotificationExceptionBuilder setExceptionModel(ExceptionModel exceptionModel) {
			this.exceptionModel = exceptionModel==null?null:exceptionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanNotificationExceptionSequence")
		public LoanNotificationException.LoanNotificationExceptionBuilder setLoanNotificationExceptionSequence(LoanNotificationExceptionSequence loanNotificationExceptionSequence) {
			this.loanNotificationExceptionSequence = loanNotificationExceptionSequence==null?null:loanNotificationExceptionSequence.toBuilder();
			return this;
		}
		
		@Override
		public LoanNotificationException build() {
			return new LoanNotificationException.LoanNotificationExceptionImpl(this);
		}
		
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder prune() {
			super.prune();
			if (loanNotificationExceptionSequence!=null && !loanNotificationExceptionSequence.prune().hasData()) loanNotificationExceptionSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanNotificationExceptionSequence()!=null && getLoanNotificationExceptionSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanNotificationException.LoanNotificationExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanNotificationException.LoanNotificationExceptionBuilder o = (LoanNotificationException.LoanNotificationExceptionBuilder) other;
			
			merger.mergeRosetta(getLoanNotificationExceptionSequence(), o.getLoanNotificationExceptionSequence(), this::setLoanNotificationExceptionSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanNotificationException _that = getType().cast(o);
		
			if (!Objects.equals(loanNotificationExceptionSequence, _that.getLoanNotificationExceptionSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanNotificationExceptionSequence != null ? loanNotificationExceptionSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanNotificationExceptionBuilder {" +
				"loanNotificationExceptionSequence=" + this.loanNotificationExceptionSequence +
			'}' + " " + super.toString();
		}
	}
}
