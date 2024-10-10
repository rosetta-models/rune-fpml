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
import fpml.confirmation.BusinessCenters;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilderImpl;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodImpl;
import fpml.confirmation.meta.FxFlexibleForwardExecutionPeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxFlexibleForwardExecutionPeriod", builder=FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilderImpl.class, version="${project.version}")
public interface FxFlexibleForwardExecutionPeriod extends RosettaModelObject {

	FxFlexibleForwardExecutionPeriodMeta metaData = new FxFlexibleForwardExecutionPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Start date of the execution period/window.
	 */
	Date getStartDate();
	/**
	 * Expiry (maturity) date of the execution period.
	 */
	Date getExpiryDate();
	/**
	 * Business centers for determination of execution period business days.
	 */
	BusinessCenters getBusinessCenters();
	String getId();

	/*********************** Build Methods  ***********************/
	FxFlexibleForwardExecutionPeriod build();
	
	FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder toBuilder();
	
	static FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder() {
		return new FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFlexibleForwardExecutionPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFlexibleForwardExecutionPeriod> getType() {
		return FxFlexibleForwardExecutionPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFlexibleForwardExecutionPeriodBuilder extends FxFlexibleForwardExecutionPeriod, RosettaModelObjectBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setStartDate(Date startDate);
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setExpiryDate(Date expiryDate);
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setBusinessCenters(BusinessCenters businessCenters);
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of FxFlexibleForwardExecutionPeriod  ***********************/
	class FxFlexibleForwardExecutionPeriodImpl implements FxFlexibleForwardExecutionPeriod {
		private final Date startDate;
		private final Date expiryDate;
		private final BusinessCenters businessCenters;
		private final String id;
		
		protected FxFlexibleForwardExecutionPeriodImpl(FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder) {
			this.startDate = builder.getStartDate();
			this.expiryDate = builder.getExpiryDate();
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod build() {
			return this;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder toBuilder() {
			FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFlexibleForwardExecutionPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardExecutionPeriod {" +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFlexibleForwardExecutionPeriod  ***********************/
	class FxFlexibleForwardExecutionPeriodBuilderImpl implements FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder {
	
		protected Date startDate;
		protected Date expiryDate;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected String id;
	
		public FxFlexibleForwardExecutionPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("startDate")
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryDate")
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("businessCenters")
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod build() {
			return new FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodImpl(this);
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder prune() {
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getExpiryDate()!=null) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder o = (FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFlexibleForwardExecutionPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardExecutionPeriodBuilder {" +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
