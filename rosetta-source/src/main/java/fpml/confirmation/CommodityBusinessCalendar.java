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
import fpml.confirmation.CommodityBusinessCalendar;
import fpml.confirmation.CommodityBusinessCalendar.CommodityBusinessCalendarBuilder;
import fpml.confirmation.CommodityBusinessCalendar.CommodityBusinessCalendarBuilderImpl;
import fpml.confirmation.CommodityBusinessCalendar.CommodityBusinessCalendarImpl;
import fpml.confirmation.meta.CommodityBusinessCalendarMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a commodity business day calendar.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityBusinessCalendar", builder=CommodityBusinessCalendar.CommodityBusinessCalendarBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityBusinessCalendar extends RosettaModelObject {

	CommodityBusinessCalendarMeta metaData = new CommodityBusinessCalendarMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityBusinessCalendarScheme();

	/*********************** Build Methods  ***********************/
	CommodityBusinessCalendar build();
	
	CommodityBusinessCalendar.CommodityBusinessCalendarBuilder toBuilder();
	
	static CommodityBusinessCalendar.CommodityBusinessCalendarBuilder builder() {
		return new CommodityBusinessCalendar.CommodityBusinessCalendarBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBusinessCalendar> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBusinessCalendar> getType() {
		return CommodityBusinessCalendar.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityBusinessCalendarScheme"), String.class, getCommodityBusinessCalendarScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBusinessCalendarBuilder extends CommodityBusinessCalendar, RosettaModelObjectBuilder {
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder setValue(String value);
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder setCommodityBusinessCalendarScheme(String commodityBusinessCalendarScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityBusinessCalendarScheme"), String.class, getCommodityBusinessCalendarScheme(), this);
		}
		

		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBusinessCalendar  ***********************/
	class CommodityBusinessCalendarImpl implements CommodityBusinessCalendar {
		private final String value;
		private final String commodityBusinessCalendarScheme;
		
		protected CommodityBusinessCalendarImpl(CommodityBusinessCalendar.CommodityBusinessCalendarBuilder builder) {
			this.value = builder.getValue();
			this.commodityBusinessCalendarScheme = builder.getCommodityBusinessCalendarScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityBusinessCalendarScheme")
		public String getCommodityBusinessCalendarScheme() {
			return commodityBusinessCalendarScheme;
		}
		
		@Override
		public CommodityBusinessCalendar build() {
			return this;
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder toBuilder() {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBusinessCalendar.CommodityBusinessCalendarBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityBusinessCalendarScheme()).ifPresent(builder::setCommodityBusinessCalendarScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBusinessCalendar _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityBusinessCalendarScheme, _that.getCommodityBusinessCalendarScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityBusinessCalendarScheme != null ? commodityBusinessCalendarScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBusinessCalendar {" +
				"value=" + this.value + ", " +
				"commodityBusinessCalendarScheme=" + this.commodityBusinessCalendarScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBusinessCalendar  ***********************/
	class CommodityBusinessCalendarBuilderImpl implements CommodityBusinessCalendar.CommodityBusinessCalendarBuilder {
	
		protected String value;
		protected String commodityBusinessCalendarScheme;
	
		public CommodityBusinessCalendarBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityBusinessCalendarScheme")
		public String getCommodityBusinessCalendarScheme() {
			return commodityBusinessCalendarScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityBusinessCalendarScheme")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder setCommodityBusinessCalendarScheme(String commodityBusinessCalendarScheme) {
			this.commodityBusinessCalendarScheme = commodityBusinessCalendarScheme==null?null:commodityBusinessCalendarScheme;
			return this;
		}
		
		@Override
		public CommodityBusinessCalendar build() {
			return new CommodityBusinessCalendar.CommodityBusinessCalendarImpl(this);
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityBusinessCalendarScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder o = (CommodityBusinessCalendar.CommodityBusinessCalendarBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityBusinessCalendarScheme(), o.getCommodityBusinessCalendarScheme(), this::setCommodityBusinessCalendarScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBusinessCalendar _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityBusinessCalendarScheme, _that.getCommodityBusinessCalendarScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityBusinessCalendarScheme != null ? commodityBusinessCalendarScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBusinessCalendarBuilder {" +
				"value=" + this.value + ", " +
				"commodityBusinessCalendarScheme=" + this.commodityBusinessCalendarScheme +
			'}';
		}
	}
}
