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
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder;
import fpml.confirmation.AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilderImpl;
import fpml.confirmation.AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelImpl;
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.meta.AgreementAndEffectiveDatesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group defining agreement and effective dates.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AgreementAndEffectiveDatesModel", builder=AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AgreementAndEffectiveDatesModel extends RosettaModelObject {

	AgreementAndEffectiveDatesModelMeta metaData = new AgreementAndEffectiveDatesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the change was agreed.
	 */
	Date getAgreementDate();
	/**
	 * The date and time at which the negotiated change to the terms of the original contract was agreed, such as via telephone or electronic trading system (i.e., agreement date/time).
	 */
	ExecutionDateTime getExecutionDateTime();
	/**
	 * The date on which the change become effective.
	 */
	Date getEffectiveDate();

	/*********************** Build Methods  ***********************/
	AgreementAndEffectiveDatesModel build();
	
	AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder toBuilder();
	
	static AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder builder() {
		return new AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgreementAndEffectiveDatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AgreementAndEffectiveDatesModel> getType() {
		return AgreementAndEffectiveDatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("agreementDate"), Date.class, getAgreementDate(), this);
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgreementAndEffectiveDatesModelBuilder extends AgreementAndEffectiveDatesModel, RosettaModelObjectBuilder {
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder setAgreementDate(Date agreementDate);
		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder setEffectiveDate(Date effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("agreementDate"), Date.class, getAgreementDate(), this);
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		}
		

		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of AgreementAndEffectiveDatesModel  ***********************/
	class AgreementAndEffectiveDatesModelImpl implements AgreementAndEffectiveDatesModel {
		private final Date agreementDate;
		private final ExecutionDateTime executionDateTime;
		private final Date effectiveDate;
		
		protected AgreementAndEffectiveDatesModelImpl(AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder builder) {
			this.agreementDate = builder.getAgreementDate();
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
		}
		
		@Override
		@RosettaAttribute("agreementDate")
		public Date getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		public ExecutionDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AgreementAndEffectiveDatesModel build() {
			return this;
		}
		
		@Override
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder toBuilder() {
			AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder builder) {
			ofNullable(getAgreementDate()).ifPresent(builder::setAgreementDate);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementAndEffectiveDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementAndEffectiveDatesModel {" +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AgreementAndEffectiveDatesModel  ***********************/
	class AgreementAndEffectiveDatesModelBuilderImpl implements AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder {
	
		protected Date agreementDate;
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected Date effectiveDate;
	
		public AgreementAndEffectiveDatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("agreementDate")
		public Date getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		public ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime() {
			ExecutionDateTime.ExecutionDateTimeBuilder result;
			if (executionDateTime!=null) {
				result = executionDateTime;
			}
			else {
				result = executionDateTime = ExecutionDateTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("agreementDate")
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder setAgreementDate(Date agreementDate) {
			this.agreementDate = agreementDate==null?null:agreementDate;
			return this;
		}
		@Override
		@RosettaAttribute("executionDateTime")
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder setExecutionDateTime(ExecutionDateTime executionDateTime) {
			this.executionDateTime = executionDateTime==null?null:executionDateTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		
		@Override
		public AgreementAndEffectiveDatesModel build() {
			return new AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelImpl(this);
		}
		
		@Override
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder prune() {
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgreementDate()!=null) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder o = (AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder) other;
			
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			
			merger.mergeBasic(getAgreementDate(), o.getAgreementDate(), this::setAgreementDate);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementAndEffectiveDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementAndEffectiveDatesModelBuilder {" +
				"agreementDate=" + this.agreementDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
