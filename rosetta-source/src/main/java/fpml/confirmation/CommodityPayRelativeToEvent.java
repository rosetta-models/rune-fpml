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
import fpml.confirmation.CommodityPayRelativeToEvent;
import fpml.confirmation.CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder;
import fpml.confirmation.CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilderImpl;
import fpml.confirmation.CommodityPayRelativeToEvent.CommodityPayRelativeToEventImpl;
import fpml.confirmation.meta.CommodityPayRelativeToEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the physical event relative to which payment occurs.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPayRelativeToEvent", builder=CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilderImpl.class, version="${project.version}")
public interface CommodityPayRelativeToEvent extends RosettaModelObject {

	CommodityPayRelativeToEventMeta metaData = new CommodityPayRelativeToEventMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityPayRelativeToEventScheme();

	/*********************** Build Methods  ***********************/
	CommodityPayRelativeToEvent build();
	
	CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder toBuilder();
	
	static CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder builder() {
		return new CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPayRelativeToEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPayRelativeToEvent> getType() {
		return CommodityPayRelativeToEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityPayRelativeToEventScheme"), String.class, getCommodityPayRelativeToEventScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPayRelativeToEventBuilder extends CommodityPayRelativeToEvent, RosettaModelObjectBuilder {
		CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder setValue(String value);
		CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder setCommodityPayRelativeToEventScheme(String commodityPayRelativeToEventScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityPayRelativeToEventScheme"), String.class, getCommodityPayRelativeToEventScheme(), this);
		}
		

		CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPayRelativeToEvent  ***********************/
	class CommodityPayRelativeToEventImpl implements CommodityPayRelativeToEvent {
		private final String value;
		private final String commodityPayRelativeToEventScheme;
		
		protected CommodityPayRelativeToEventImpl(CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder builder) {
			this.value = builder.getValue();
			this.commodityPayRelativeToEventScheme = builder.getCommodityPayRelativeToEventScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityPayRelativeToEventScheme")
		public String getCommodityPayRelativeToEventScheme() {
			return commodityPayRelativeToEventScheme;
		}
		
		@Override
		public CommodityPayRelativeToEvent build() {
			return this;
		}
		
		@Override
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder toBuilder() {
			CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityPayRelativeToEventScheme()).ifPresent(builder::setCommodityPayRelativeToEventScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPayRelativeToEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityPayRelativeToEventScheme, _that.getCommodityPayRelativeToEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityPayRelativeToEventScheme != null ? commodityPayRelativeToEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPayRelativeToEvent {" +
				"value=" + this.value + ", " +
				"commodityPayRelativeToEventScheme=" + this.commodityPayRelativeToEventScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPayRelativeToEvent  ***********************/
	class CommodityPayRelativeToEventBuilderImpl implements CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder {
	
		protected String value;
		protected String commodityPayRelativeToEventScheme;
	
		public CommodityPayRelativeToEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityPayRelativeToEventScheme")
		public String getCommodityPayRelativeToEventScheme() {
			return commodityPayRelativeToEventScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityPayRelativeToEventScheme")
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder setCommodityPayRelativeToEventScheme(String commodityPayRelativeToEventScheme) {
			this.commodityPayRelativeToEventScheme = commodityPayRelativeToEventScheme==null?null:commodityPayRelativeToEventScheme;
			return this;
		}
		
		@Override
		public CommodityPayRelativeToEvent build() {
			return new CommodityPayRelativeToEvent.CommodityPayRelativeToEventImpl(this);
		}
		
		@Override
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityPayRelativeToEventScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder o = (CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityPayRelativeToEventScheme(), o.getCommodityPayRelativeToEventScheme(), this::setCommodityPayRelativeToEventScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPayRelativeToEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityPayRelativeToEventScheme, _that.getCommodityPayRelativeToEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityPayRelativeToEventScheme != null ? commodityPayRelativeToEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPayRelativeToEventBuilder {" +
				"value=" + this.value + ", " +
				"commodityPayRelativeToEventScheme=" + this.commodityPayRelativeToEventScheme +
			'}';
		}
	}
}
