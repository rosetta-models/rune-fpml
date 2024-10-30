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
import fpml.confirmation.InformationSource;
import fpml.confirmation.ObservedRate;
import fpml.confirmation.ObservedRate.ObservedRateBuilder;
import fpml.confirmation.ObservedRate.ObservedRateBuilderImpl;
import fpml.confirmation.ObservedRate.ObservedRateImpl;
import fpml.confirmation.meta.ObservedRateMeta;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ObservedRate", builder=ObservedRate.ObservedRateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ObservedRate extends RosettaModelObject {

	ObservedRateMeta metaData = new ObservedRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The observed rate value which triggered the barrier event.
	 */
	BigDecimal getRate();
	/**
	 * The date when the rate was observed.
	 */
	Date getDate();
	/**
	 * The time when the rate ws observed.
	 */
	LocalTime getTime();
	/**
	 * The source of the observation.
	 */
	InformationSource getInformationSource();

	/*********************** Build Methods  ***********************/
	ObservedRate build();
	
	ObservedRate.ObservedRateBuilder toBuilder();
	
	static ObservedRate.ObservedRateBuilder builder() {
		return new ObservedRate.ObservedRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservedRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObservedRate> getType() {
		return ObservedRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservedRateBuilder extends ObservedRate, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		InformationSource.InformationSourceBuilder getInformationSource();
		ObservedRate.ObservedRateBuilder setRate(BigDecimal rate);
		ObservedRate.ObservedRateBuilder setDate(Date date);
		ObservedRate.ObservedRateBuilder setTime(LocalTime time);
		ObservedRate.ObservedRateBuilder setInformationSource(InformationSource informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
		}
		

		ObservedRate.ObservedRateBuilder prune();
	}

	/*********************** Immutable Implementation of ObservedRate  ***********************/
	class ObservedRateImpl implements ObservedRate {
		private final BigDecimal rate;
		private final Date date;
		private final LocalTime time;
		private final InformationSource informationSource;
		
		protected ObservedRateImpl(ObservedRate.ObservedRateBuilder builder) {
			this.rate = builder.getRate();
			this.date = builder.getDate();
			this.time = builder.getTime();
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public InformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		public ObservedRate build() {
			return this;
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder toBuilder() {
			ObservedRate.ObservedRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservedRate.ObservedRateBuilder builder) {
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedRate {" +
				"rate=" + this.rate + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservedRate  ***********************/
	class ObservedRateBuilderImpl implements ObservedRate.ObservedRateBuilder {
	
		protected BigDecimal rate;
		protected Date date;
		protected LocalTime time;
		protected InformationSource.InformationSourceBuilder informationSource;
	
		public ObservedRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public InformationSource.InformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource() {
			InformationSource.InformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rate")
		public ObservedRate.ObservedRateBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		@Override
		@RosettaAttribute("date")
		public ObservedRate.ObservedRateBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("time")
		public ObservedRate.ObservedRateBuilder setTime(LocalTime time) {
			this.time = time==null?null:time;
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public ObservedRate.ObservedRateBuilder setInformationSource(InformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		
		@Override
		public ObservedRate build() {
			return new ObservedRate.ObservedRateImpl(this);
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedRate.ObservedRateBuilder prune() {
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRate()!=null) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedRate.ObservedRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservedRate.ObservedRateBuilder o = (ObservedRate.ObservedRateBuilder) other;
			
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedRateBuilder {" +
				"rate=" + this.rate + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}
}
