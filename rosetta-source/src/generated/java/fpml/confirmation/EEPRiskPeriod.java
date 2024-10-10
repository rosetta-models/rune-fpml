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
import fpml.confirmation.EEPRiskPeriod;
import fpml.confirmation.EEPRiskPeriod.EEPRiskPeriodBuilder;
import fpml.confirmation.EEPRiskPeriod.EEPRiskPeriodBuilderImpl;
import fpml.confirmation.EEPRiskPeriod.EEPRiskPeriodImpl;
import fpml.confirmation.meta.EEPRiskPeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * TBD.
 * @version ${project.version}
 */
@RosettaDataType(value="EEPRiskPeriod", builder=EEPRiskPeriod.EEPRiskPeriodBuilderImpl.class, version="${project.version}")
public interface EEPRiskPeriod extends RosettaModelObject {

	EEPRiskPeriodMeta metaData = new EEPRiskPeriodMeta();

	/*********************** Getter Methods  ***********************/
	Date getStartDate();
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	EEPRiskPeriod build();
	
	EEPRiskPeriod.EEPRiskPeriodBuilder toBuilder();
	
	static EEPRiskPeriod.EEPRiskPeriodBuilder builder() {
		return new EEPRiskPeriod.EEPRiskPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EEPRiskPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EEPRiskPeriod> getType() {
		return EEPRiskPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EEPRiskPeriodBuilder extends EEPRiskPeriod, RosettaModelObjectBuilder {
		EEPRiskPeriod.EEPRiskPeriodBuilder setStartDate(Date startDate);
		EEPRiskPeriod.EEPRiskPeriodBuilder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		EEPRiskPeriod.EEPRiskPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of EEPRiskPeriod  ***********************/
	class EEPRiskPeriodImpl implements EEPRiskPeriod {
		private final Date startDate;
		private final Date endDate;
		
		protected EEPRiskPeriodImpl(EEPRiskPeriod.EEPRiskPeriodBuilder builder) {
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
		public EEPRiskPeriod build() {
			return this;
		}
		
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder toBuilder() {
			EEPRiskPeriod.EEPRiskPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EEPRiskPeriod.EEPRiskPeriodBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EEPRiskPeriod _that = getType().cast(o);
		
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
			return "EEPRiskPeriod {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of EEPRiskPeriod  ***********************/
	class EEPRiskPeriodBuilderImpl implements EEPRiskPeriod.EEPRiskPeriodBuilder {
	
		protected Date startDate;
		protected Date endDate;
	
		public EEPRiskPeriodBuilderImpl() {
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
		public EEPRiskPeriod.EEPRiskPeriodBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public EEPRiskPeriod.EEPRiskPeriodBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		
		@Override
		public EEPRiskPeriod build() {
			return new EEPRiskPeriod.EEPRiskPeriodImpl(this);
		}
		
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder prune() {
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
		public EEPRiskPeriod.EEPRiskPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EEPRiskPeriod.EEPRiskPeriodBuilder o = (EEPRiskPeriod.EEPRiskPeriodBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EEPRiskPeriod _that = getType().cast(o);
		
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
			return "EEPRiskPeriodBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
