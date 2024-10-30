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
import fpml.confirmation.PeriodModel;
import fpml.confirmation.PeriodModel.PeriodModelBuilder;
import fpml.confirmation.PeriodModel.PeriodModelBuilderImpl;
import fpml.confirmation.PeriodModel.PeriodModelImpl;
import fpml.confirmation.meta.PeriodModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PeriodModel", builder=PeriodModel.PeriodModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PeriodModel extends RosettaModelObject {

	PeriodModelMeta metaData = new PeriodModelMeta();

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
	PeriodModel build();
	
	PeriodModel.PeriodModelBuilder toBuilder();
	
	static PeriodModel.PeriodModelBuilder builder() {
		return new PeriodModel.PeriodModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PeriodModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PeriodModel> getType() {
		return PeriodModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodModelBuilder extends PeriodModel, RosettaModelObjectBuilder {
		PeriodModel.PeriodModelBuilder setStartDate(Date startDate);
		PeriodModel.PeriodModelBuilder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		PeriodModel.PeriodModelBuilder prune();
	}

	/*********************** Immutable Implementation of PeriodModel  ***********************/
	class PeriodModelImpl implements PeriodModel {
		private final Date startDate;
		private final Date endDate;
		
		protected PeriodModelImpl(PeriodModel.PeriodModelBuilder builder) {
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
		public PeriodModel build() {
			return this;
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder toBuilder() {
			PeriodModel.PeriodModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodModel.PeriodModelBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodModel _that = getType().cast(o);
		
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
			return "PeriodModel {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of PeriodModel  ***********************/
	class PeriodModelBuilderImpl implements PeriodModel.PeriodModelBuilder {
	
		protected Date startDate;
		protected Date endDate;
	
		public PeriodModelBuilderImpl() {
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
		public PeriodModel.PeriodModelBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public PeriodModel.PeriodModelBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		
		@Override
		public PeriodModel build() {
			return new PeriodModel.PeriodModelImpl(this);
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodModel.PeriodModelBuilder prune() {
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
		public PeriodModel.PeriodModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodModel.PeriodModelBuilder o = (PeriodModel.PeriodModelBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodModel _that = getType().cast(o);
		
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
			return "PeriodModelBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
