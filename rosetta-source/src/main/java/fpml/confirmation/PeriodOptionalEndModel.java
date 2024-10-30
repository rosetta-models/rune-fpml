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
import fpml.confirmation.PeriodOptionalEndModel;
import fpml.confirmation.PeriodOptionalEndModel.PeriodOptionalEndModelBuilder;
import fpml.confirmation.PeriodOptionalEndModel.PeriodOptionalEndModelBuilderImpl;
import fpml.confirmation.PeriodOptionalEndModel.PeriodOptionalEndModelImpl;
import fpml.confirmation.meta.PeriodOptionalEndModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes a period, with an optional end date.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PeriodOptionalEndModel", builder=PeriodOptionalEndModel.PeriodOptionalEndModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PeriodOptionalEndModel extends RosettaModelObject {

	PeriodOptionalEndModelMeta metaData = new PeriodOptionalEndModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Date on which this period begins.
	 */
	Date getStartDate();
	/**
	 * Date on which this period ends.
	 */
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	PeriodOptionalEndModel build();
	
	PeriodOptionalEndModel.PeriodOptionalEndModelBuilder toBuilder();
	
	static PeriodOptionalEndModel.PeriodOptionalEndModelBuilder builder() {
		return new PeriodOptionalEndModel.PeriodOptionalEndModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PeriodOptionalEndModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PeriodOptionalEndModel> getType() {
		return PeriodOptionalEndModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodOptionalEndModelBuilder extends PeriodOptionalEndModel, RosettaModelObjectBuilder {
		PeriodOptionalEndModel.PeriodOptionalEndModelBuilder setStartDate(Date startDate);
		PeriodOptionalEndModel.PeriodOptionalEndModelBuilder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		PeriodOptionalEndModel.PeriodOptionalEndModelBuilder prune();
	}

	/*********************** Immutable Implementation of PeriodOptionalEndModel  ***********************/
	class PeriodOptionalEndModelImpl implements PeriodOptionalEndModel {
		private final Date startDate;
		private final Date endDate;
		
		protected PeriodOptionalEndModelImpl(PeriodOptionalEndModel.PeriodOptionalEndModelBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public PeriodOptionalEndModel build() {
			return this;
		}
		
		@Override
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder toBuilder() {
			PeriodOptionalEndModel.PeriodOptionalEndModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodOptionalEndModel.PeriodOptionalEndModelBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodOptionalEndModel _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodOptionalEndModel {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of PeriodOptionalEndModel  ***********************/
	class PeriodOptionalEndModelBuilderImpl implements PeriodOptionalEndModel.PeriodOptionalEndModelBuilder {
	
		protected Date startDate;
		protected Date endDate;
	
		public PeriodOptionalEndModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		
		@Override
		public PeriodOptionalEndModel build() {
			return new PeriodOptionalEndModel.PeriodOptionalEndModelImpl(this);
		}
		
		@Override
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodOptionalEndModel.PeriodOptionalEndModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodOptionalEndModel.PeriodOptionalEndModelBuilder o = (PeriodOptionalEndModel.PeriodOptionalEndModelBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodOptionalEndModel _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodOptionalEndModelBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
