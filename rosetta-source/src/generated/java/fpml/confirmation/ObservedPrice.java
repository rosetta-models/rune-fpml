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
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ObservedPrice;
import fpml.confirmation.ObservedPrice.ObservedPriceBuilder;
import fpml.confirmation.ObservedPrice.ObservedPriceBuilderImpl;
import fpml.confirmation.ObservedPrice.ObservedPriceImpl;
import fpml.confirmation.meta.ObservedPriceMeta;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ObservedPrice", builder=ObservedPrice.ObservedPriceBuilderImpl.class, version="${project.version}")
public interface ObservedPrice extends RosettaModelObject {

	ObservedPriceMeta metaData = new ObservedPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The observed rate value which triggered the barrier event.
	 */
	NonNegativeMoney getPrice();
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
	ObservedPrice build();
	
	ObservedPrice.ObservedPriceBuilder toBuilder();
	
	static ObservedPrice.ObservedPriceBuilder builder() {
		return new ObservedPrice.ObservedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservedPrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObservedPrice> getType() {
		return ObservedPrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("price"), processor, NonNegativeMoney.class, getPrice());
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservedPriceBuilder extends ObservedPrice, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getPrice();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		InformationSource.InformationSourceBuilder getInformationSource();
		ObservedPrice.ObservedPriceBuilder setPrice(NonNegativeMoney price);
		ObservedPrice.ObservedPriceBuilder setDate(Date date);
		ObservedPrice.ObservedPriceBuilder setTime(LocalTime time);
		ObservedPrice.ObservedPriceBuilder setInformationSource(InformationSource informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("price"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPrice());
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
		}
		

		ObservedPrice.ObservedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ObservedPrice  ***********************/
	class ObservedPriceImpl implements ObservedPrice {
		private final NonNegativeMoney price;
		private final Date date;
		private final LocalTime time;
		private final InformationSource informationSource;
		
		protected ObservedPriceImpl(ObservedPrice.ObservedPriceBuilder builder) {
			this.price = ofNullable(builder.getPrice()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
			this.time = builder.getTime();
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("price")
		public NonNegativeMoney getPrice() {
			return price;
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
		public ObservedPrice build() {
			return this;
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder toBuilder() {
			ObservedPrice.ObservedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservedPrice.ObservedPriceBuilder builder) {
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedPrice {" +
				"price=" + this.price + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservedPrice  ***********************/
	class ObservedPriceBuilderImpl implements ObservedPrice.ObservedPriceBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder price;
		protected Date date;
		protected LocalTime time;
		protected InformationSource.InformationSourceBuilder informationSource;
	
		public ObservedPriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("price")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPrice() {
			return price;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = NonNegativeMoney.builder();
			}
			
			return result;
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
		@RosettaAttribute("price")
		public ObservedPrice.ObservedPriceBuilder setPrice(NonNegativeMoney price) {
			this.price = price==null?null:price.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("date")
		public ObservedPrice.ObservedPriceBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("time")
		public ObservedPrice.ObservedPriceBuilder setTime(LocalTime time) {
			this.time = time==null?null:time;
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public ObservedPrice.ObservedPriceBuilder setInformationSource(InformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		
		@Override
		public ObservedPrice build() {
			return new ObservedPrice.ObservedPriceImpl(this);
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedPrice.ObservedPriceBuilder prune() {
			if (price!=null && !price.prune().hasData()) price = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrice()!=null && getPrice().hasData()) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedPrice.ObservedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservedPrice.ObservedPriceBuilder o = (ObservedPrice.ObservedPriceBuilder) other;
			
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedPriceBuilder {" +
				"price=" + this.price + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}
}
