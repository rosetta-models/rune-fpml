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
import fpml.confirmation.EnvironmentalTrackingSystem;
import fpml.confirmation.EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder;
import fpml.confirmation.EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilderImpl;
import fpml.confirmation.EnvironmentalTrackingSystem.EnvironmentalTrackingSystemImpl;
import fpml.confirmation.meta.EnvironmentalTrackingSystemMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * For US Emissions Allowance Transactions. A system where all electronic certificates are stored and emissions are tracked.
 * @version ${project.version}
 */
@RosettaDataType(value="EnvironmentalTrackingSystem", builder=EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilderImpl.class, version="${project.version}")
public interface EnvironmentalTrackingSystem extends RosettaModelObject {

	EnvironmentalTrackingSystemMeta metaData = new EnvironmentalTrackingSystemMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityEnvironmentalTrackingSystemScheme();

	/*********************** Build Methods  ***********************/
	EnvironmentalTrackingSystem build();
	
	EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder toBuilder();
	
	static EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder() {
		return new EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalTrackingSystem> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EnvironmentalTrackingSystem> getType() {
		return EnvironmentalTrackingSystem.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityEnvironmentalTrackingSystemScheme"), String.class, getCommodityEnvironmentalTrackingSystemScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalTrackingSystemBuilder extends EnvironmentalTrackingSystem, RosettaModelObjectBuilder {
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setValue(String value);
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setCommodityEnvironmentalTrackingSystemScheme(String commodityEnvironmentalTrackingSystemScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityEnvironmentalTrackingSystemScheme"), String.class, getCommodityEnvironmentalTrackingSystemScheme(), this);
		}
		

		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalTrackingSystem  ***********************/
	class EnvironmentalTrackingSystemImpl implements EnvironmentalTrackingSystem {
		private final String value;
		private final String commodityEnvironmentalTrackingSystemScheme;
		
		protected EnvironmentalTrackingSystemImpl(EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder) {
			this.value = builder.getValue();
			this.commodityEnvironmentalTrackingSystemScheme = builder.getCommodityEnvironmentalTrackingSystemScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityEnvironmentalTrackingSystemScheme")
		public String getCommodityEnvironmentalTrackingSystemScheme() {
			return commodityEnvironmentalTrackingSystemScheme;
		}
		
		@Override
		public EnvironmentalTrackingSystem build() {
			return this;
		}
		
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder toBuilder() {
			EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityEnvironmentalTrackingSystemScheme()).ifPresent(builder::setCommodityEnvironmentalTrackingSystemScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalTrackingSystem _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityEnvironmentalTrackingSystemScheme, _that.getCommodityEnvironmentalTrackingSystemScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityEnvironmentalTrackingSystemScheme != null ? commodityEnvironmentalTrackingSystemScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalTrackingSystem {" +
				"value=" + this.value + ", " +
				"commodityEnvironmentalTrackingSystemScheme=" + this.commodityEnvironmentalTrackingSystemScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalTrackingSystem  ***********************/
	class EnvironmentalTrackingSystemBuilderImpl implements EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder {
	
		protected String value;
		protected String commodityEnvironmentalTrackingSystemScheme;
	
		public EnvironmentalTrackingSystemBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityEnvironmentalTrackingSystemScheme")
		public String getCommodityEnvironmentalTrackingSystemScheme() {
			return commodityEnvironmentalTrackingSystemScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityEnvironmentalTrackingSystemScheme")
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder setCommodityEnvironmentalTrackingSystemScheme(String commodityEnvironmentalTrackingSystemScheme) {
			this.commodityEnvironmentalTrackingSystemScheme = commodityEnvironmentalTrackingSystemScheme==null?null:commodityEnvironmentalTrackingSystemScheme;
			return this;
		}
		
		@Override
		public EnvironmentalTrackingSystem build() {
			return new EnvironmentalTrackingSystem.EnvironmentalTrackingSystemImpl(this);
		}
		
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityEnvironmentalTrackingSystemScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder o = (EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityEnvironmentalTrackingSystemScheme(), o.getCommodityEnvironmentalTrackingSystemScheme(), this::setCommodityEnvironmentalTrackingSystemScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalTrackingSystem _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityEnvironmentalTrackingSystemScheme, _that.getCommodityEnvironmentalTrackingSystemScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityEnvironmentalTrackingSystemScheme != null ? commodityEnvironmentalTrackingSystemScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalTrackingSystemBuilder {" +
				"value=" + this.value + ", " +
				"commodityEnvironmentalTrackingSystemScheme=" + this.commodityEnvironmentalTrackingSystemScheme +
			'}';
		}
	}
}
