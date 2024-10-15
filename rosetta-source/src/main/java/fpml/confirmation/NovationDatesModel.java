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
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.NovationDatesModel;
import fpml.confirmation.NovationDatesModel.NovationDatesModelBuilder;
import fpml.confirmation.NovationDatesModel.NovationDatesModelBuilderImpl;
import fpml.confirmation.NovationDatesModel.NovationDatesModelImpl;
import fpml.confirmation.meta.NovationDatesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NovationDatesModel", builder=NovationDatesModel.NovationDatesModelBuilderImpl.class, version="${project.version}")
public interface NovationDatesModel extends RosettaModelObject {

	NovationDatesModelMeta metaData = new NovationDatesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the date that one party&#39;s legal obligations with regard to a trade are transferred to another party. It corresponds to the Novation Date section of the 2004 ISDA Novation Definitions, section 1.16.
	 */
	Date getNovationDate();
	/**
	 * The date and time at which the change was agreed.
	 */
	ExecutionDateTime getExecutionDateTime();
	/**
	 * Specifies the date the parties agree to assign or novate a Contract. If this element is not specified, the novationContractDate will be deemed to be the novationDate. It corresponds to the Novation Trade Date section of the 2004 ISDA Novation Definitions, section 1.17.
	 */
	Date getNovationTradeDate();

	/*********************** Build Methods  ***********************/
	NovationDatesModel build();
	
	NovationDatesModel.NovationDatesModelBuilder toBuilder();
	
	static NovationDatesModel.NovationDatesModelBuilder builder() {
		return new NovationDatesModel.NovationDatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationDatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationDatesModel> getType() {
		return NovationDatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("novationDate"), Date.class, getNovationDate(), this);
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processor.processBasic(path.newSubPath("novationTradeDate"), Date.class, getNovationTradeDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationDatesModelBuilder extends NovationDatesModel, RosettaModelObjectBuilder {
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		NovationDatesModel.NovationDatesModelBuilder setNovationDate(Date novationDate);
		NovationDatesModel.NovationDatesModelBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		NovationDatesModel.NovationDatesModelBuilder setNovationTradeDate(Date novationTradeDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("novationDate"), Date.class, getNovationDate(), this);
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processor.processBasic(path.newSubPath("novationTradeDate"), Date.class, getNovationTradeDate(), this);
		}
		

		NovationDatesModel.NovationDatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of NovationDatesModel  ***********************/
	class NovationDatesModelImpl implements NovationDatesModel {
		private final Date novationDate;
		private final ExecutionDateTime executionDateTime;
		private final Date novationTradeDate;
		
		protected NovationDatesModelImpl(NovationDatesModel.NovationDatesModelBuilder builder) {
			this.novationDate = builder.getNovationDate();
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.novationTradeDate = builder.getNovationTradeDate();
		}
		
		@Override
		@RosettaAttribute("novationDate")
		public Date getNovationDate() {
			return novationDate;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		public ExecutionDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("novationTradeDate")
		public Date getNovationTradeDate() {
			return novationTradeDate;
		}
		
		@Override
		public NovationDatesModel build() {
			return this;
		}
		
		@Override
		public NovationDatesModel.NovationDatesModelBuilder toBuilder() {
			NovationDatesModel.NovationDatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationDatesModel.NovationDatesModelBuilder builder) {
			ofNullable(getNovationDate()).ifPresent(builder::setNovationDate);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getNovationTradeDate()).ifPresent(builder::setNovationTradeDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(novationDate, _that.getNovationDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(novationTradeDate, _that.getNovationTradeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novationDate != null ? novationDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (novationTradeDate != null ? novationTradeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationDatesModel {" +
				"novationDate=" + this.novationDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"novationTradeDate=" + this.novationTradeDate +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationDatesModel  ***********************/
	class NovationDatesModelBuilderImpl implements NovationDatesModel.NovationDatesModelBuilder {
	
		protected Date novationDate;
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected Date novationTradeDate;
	
		public NovationDatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("novationDate")
		public Date getNovationDate() {
			return novationDate;
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
		@RosettaAttribute("novationTradeDate")
		public Date getNovationTradeDate() {
			return novationTradeDate;
		}
		
		@Override
		@RosettaAttribute("novationDate")
		public NovationDatesModel.NovationDatesModelBuilder setNovationDate(Date novationDate) {
			this.novationDate = novationDate==null?null:novationDate;
			return this;
		}
		@Override
		@RosettaAttribute("executionDateTime")
		public NovationDatesModel.NovationDatesModelBuilder setExecutionDateTime(ExecutionDateTime executionDateTime) {
			this.executionDateTime = executionDateTime==null?null:executionDateTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationTradeDate")
		public NovationDatesModel.NovationDatesModelBuilder setNovationTradeDate(Date novationTradeDate) {
			this.novationTradeDate = novationTradeDate==null?null:novationTradeDate;
			return this;
		}
		
		@Override
		public NovationDatesModel build() {
			return new NovationDatesModel.NovationDatesModelImpl(this);
		}
		
		@Override
		public NovationDatesModel.NovationDatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationDatesModel.NovationDatesModelBuilder prune() {
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNovationDate()!=null) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getNovationTradeDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationDatesModel.NovationDatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationDatesModel.NovationDatesModelBuilder o = (NovationDatesModel.NovationDatesModelBuilder) other;
			
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			
			merger.mergeBasic(getNovationDate(), o.getNovationDate(), this::setNovationDate);
			merger.mergeBasic(getNovationTradeDate(), o.getNovationTradeDate(), this::setNovationTradeDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(novationDate, _that.getNovationDate())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(novationTradeDate, _that.getNovationTradeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novationDate != null ? novationDate.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (novationTradeDate != null ? novationTradeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationDatesModelBuilder {" +
				"novationDate=" + this.novationDate + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"novationTradeDate=" + this.novationTradeDate +
			'}';
		}
	}
}
