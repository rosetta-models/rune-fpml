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
import fpml.confirmation.CoalProductSource;
import fpml.confirmation.CoalProductSource.CoalProductSourceBuilder;
import fpml.confirmation.CoalProductSource.CoalProductSourceBuilderImpl;
import fpml.confirmation.CoalProductSource.CoalProductSourceImpl;
import fpml.confirmation.meta.CoalProductSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the sources of coal for a physically settled coal trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CoalProductSource", builder=CoalProductSource.CoalProductSourceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CoalProductSource extends RosettaModelObject {

	CoalProductSourceMeta metaData = new CoalProductSourceMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityCoalProductSourceScheme();

	/*********************** Build Methods  ***********************/
	CoalProductSource build();
	
	CoalProductSource.CoalProductSourceBuilder toBuilder();
	
	static CoalProductSource.CoalProductSourceBuilder builder() {
		return new CoalProductSource.CoalProductSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalProductSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalProductSource> getType() {
		return CoalProductSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityCoalProductSourceScheme"), String.class, getCommodityCoalProductSourceScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalProductSourceBuilder extends CoalProductSource, RosettaModelObjectBuilder {
		CoalProductSource.CoalProductSourceBuilder setValue(String value);
		CoalProductSource.CoalProductSourceBuilder setCommodityCoalProductSourceScheme(String commodityCoalProductSourceScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityCoalProductSourceScheme"), String.class, getCommodityCoalProductSourceScheme(), this);
		}
		

		CoalProductSource.CoalProductSourceBuilder prune();
	}

	/*********************** Immutable Implementation of CoalProductSource  ***********************/
	class CoalProductSourceImpl implements CoalProductSource {
		private final String value;
		private final String commodityCoalProductSourceScheme;
		
		protected CoalProductSourceImpl(CoalProductSource.CoalProductSourceBuilder builder) {
			this.value = builder.getValue();
			this.commodityCoalProductSourceScheme = builder.getCommodityCoalProductSourceScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalProductSourceScheme")
		public String getCommodityCoalProductSourceScheme() {
			return commodityCoalProductSourceScheme;
		}
		
		@Override
		public CoalProductSource build() {
			return this;
		}
		
		@Override
		public CoalProductSource.CoalProductSourceBuilder toBuilder() {
			CoalProductSource.CoalProductSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalProductSource.CoalProductSourceBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityCoalProductSourceScheme()).ifPresent(builder::setCommodityCoalProductSourceScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProductSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalProductSourceScheme, _that.getCommodityCoalProductSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalProductSourceScheme != null ? commodityCoalProductSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductSource {" +
				"value=" + this.value + ", " +
				"commodityCoalProductSourceScheme=" + this.commodityCoalProductSourceScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalProductSource  ***********************/
	class CoalProductSourceBuilderImpl implements CoalProductSource.CoalProductSourceBuilder {
	
		protected String value;
		protected String commodityCoalProductSourceScheme;
	
		public CoalProductSourceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityCoalProductSourceScheme")
		public String getCommodityCoalProductSourceScheme() {
			return commodityCoalProductSourceScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CoalProductSource.CoalProductSourceBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityCoalProductSourceScheme")
		public CoalProductSource.CoalProductSourceBuilder setCommodityCoalProductSourceScheme(String commodityCoalProductSourceScheme) {
			this.commodityCoalProductSourceScheme = commodityCoalProductSourceScheme==null?null:commodityCoalProductSourceScheme;
			return this;
		}
		
		@Override
		public CoalProductSource build() {
			return new CoalProductSource.CoalProductSourceImpl(this);
		}
		
		@Override
		public CoalProductSource.CoalProductSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProductSource.CoalProductSourceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityCoalProductSourceScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProductSource.CoalProductSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalProductSource.CoalProductSourceBuilder o = (CoalProductSource.CoalProductSourceBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityCoalProductSourceScheme(), o.getCommodityCoalProductSourceScheme(), this::setCommodityCoalProductSourceScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProductSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityCoalProductSourceScheme, _that.getCommodityCoalProductSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityCoalProductSourceScheme != null ? commodityCoalProductSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductSourceBuilder {" +
				"value=" + this.value + ", " +
				"commodityCoalProductSourceScheme=" + this.commodityCoalProductSourceScheme +
			'}';
		}
	}
}
