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
import fpml.confirmation.ElectricityProduct;
import fpml.confirmation.ElectricityProduct.ElectricityProductBuilder;
import fpml.confirmation.ElectricityProduct.ElectricityProductBuilderImpl;
import fpml.confirmation.ElectricityProduct.ElectricityProductImpl;
import fpml.confirmation.ElectricityProductTypeEnum;
import fpml.confirmation.meta.ElectricityProductMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The specification of the electricity to be delivered.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ElectricityProduct", builder=ElectricityProduct.ElectricityProductBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ElectricityProduct extends RosettaModelObject {

	ElectricityProductMeta metaData = new ElectricityProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of electricity product to be delivered.
	 */
	ElectricityProductTypeEnum get_type();
	/**
	 * The voltage, expressed as a number of volts, of the electricity to be delivered.
	 */
	BigDecimal getVoltage();

	/*********************** Build Methods  ***********************/
	ElectricityProduct build();
	
	ElectricityProduct.ElectricityProductBuilder toBuilder();
	
	static ElectricityProduct.ElectricityProductBuilder builder() {
		return new ElectricityProduct.ElectricityProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityProduct> getType() {
		return ElectricityProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("_type"), ElectricityProductTypeEnum.class, get_type(), this);
		processor.processBasic(path.newSubPath("voltage"), BigDecimal.class, getVoltage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityProductBuilder extends ElectricityProduct, RosettaModelObjectBuilder {
		ElectricityProduct.ElectricityProductBuilder set_type(ElectricityProductTypeEnum _type);
		ElectricityProduct.ElectricityProductBuilder setVoltage(BigDecimal voltage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("_type"), ElectricityProductTypeEnum.class, get_type(), this);
			processor.processBasic(path.newSubPath("voltage"), BigDecimal.class, getVoltage(), this);
		}
		

		ElectricityProduct.ElectricityProductBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityProduct  ***********************/
	class ElectricityProductImpl implements ElectricityProduct {
		private final ElectricityProductTypeEnum _type;
		private final BigDecimal voltage;
		
		protected ElectricityProductImpl(ElectricityProduct.ElectricityProductBuilder builder) {
			this._type = builder.get_type();
			this.voltage = builder.getVoltage();
		}
		
		@Override
		@RosettaAttribute("_type")
		public ElectricityProductTypeEnum get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("voltage")
		public BigDecimal getVoltage() {
			return voltage;
		}
		
		@Override
		public ElectricityProduct build() {
			return this;
		}
		
		@Override
		public ElectricityProduct.ElectricityProductBuilder toBuilder() {
			ElectricityProduct.ElectricityProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityProduct.ElectricityProductBuilder builder) {
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getVoltage()).ifPresent(builder::setVoltage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityProduct _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(voltage, _that.getVoltage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (voltage != null ? voltage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityProduct {" +
				"_type=" + this._type + ", " +
				"voltage=" + this.voltage +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityProduct  ***********************/
	class ElectricityProductBuilderImpl implements ElectricityProduct.ElectricityProductBuilder {
	
		protected ElectricityProductTypeEnum _type;
		protected BigDecimal voltage;
	
		public ElectricityProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("_type")
		public ElectricityProductTypeEnum get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("voltage")
		public BigDecimal getVoltage() {
			return voltage;
		}
		
		@Override
		@RosettaAttribute("_type")
		public ElectricityProduct.ElectricityProductBuilder set_type(ElectricityProductTypeEnum _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		@Override
		@RosettaAttribute("voltage")
		public ElectricityProduct.ElectricityProductBuilder setVoltage(BigDecimal voltage) {
			this.voltage = voltage==null?null:voltage;
			return this;
		}
		
		@Override
		public ElectricityProduct build() {
			return new ElectricityProduct.ElectricityProductImpl(this);
		}
		
		@Override
		public ElectricityProduct.ElectricityProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityProduct.ElectricityProductBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (get_type()!=null) return true;
			if (getVoltage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityProduct.ElectricityProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityProduct.ElectricityProductBuilder o = (ElectricityProduct.ElectricityProductBuilder) other;
			
			
			merger.mergeBasic(get_type(), o.get_type(), this::set_type);
			merger.mergeBasic(getVoltage(), o.getVoltage(), this::setVoltage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityProduct _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(voltage, _that.getVoltage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (voltage != null ? voltage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityProductBuilder {" +
				"_type=" + this._type + ", " +
				"voltage=" + this.voltage +
			'}';
		}
	}
}
