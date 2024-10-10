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
import fpml.confirmation.BasketId;
import fpml.confirmation.BasketId.BasketIdBuilder;
import fpml.confirmation.BasketId.BasketIdBuilderImpl;
import fpml.confirmation.BasketId.BasketIdImpl;
import fpml.confirmation.meta.BasketIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="BasketId", builder=BasketId.BasketIdBuilderImpl.class, version="${project.version}")
public interface BasketId extends RosettaModelObject {

	BasketIdMeta metaData = new BasketIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getBasketIdScheme();

	/*********************** Build Methods  ***********************/
	BasketId build();
	
	BasketId.BasketIdBuilder toBuilder();
	
	static BasketId.BasketIdBuilder builder() {
		return new BasketId.BasketIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasketId> getType() {
		return BasketId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("basketIdScheme"), String.class, getBasketIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketIdBuilder extends BasketId, RosettaModelObjectBuilder {
		BasketId.BasketIdBuilder setValue(String value);
		BasketId.BasketIdBuilder setBasketIdScheme(String basketIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("basketIdScheme"), String.class, getBasketIdScheme(), this);
		}
		

		BasketId.BasketIdBuilder prune();
	}

	/*********************** Immutable Implementation of BasketId  ***********************/
	class BasketIdImpl implements BasketId {
		private final String value;
		private final String basketIdScheme;
		
		protected BasketIdImpl(BasketId.BasketIdBuilder builder) {
			this.value = builder.getValue();
			this.basketIdScheme = builder.getBasketIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("basketIdScheme")
		public String getBasketIdScheme() {
			return basketIdScheme;
		}
		
		@Override
		public BasketId build() {
			return this;
		}
		
		@Override
		public BasketId.BasketIdBuilder toBuilder() {
			BasketId.BasketIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketId.BasketIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBasketIdScheme()).ifPresent(builder::setBasketIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(basketIdScheme, _that.getBasketIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (basketIdScheme != null ? basketIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketId {" +
				"value=" + this.value + ", " +
				"basketIdScheme=" + this.basketIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketId  ***********************/
	class BasketIdBuilderImpl implements BasketId.BasketIdBuilder {
	
		protected String value;
		protected String basketIdScheme;
	
		public BasketIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("basketIdScheme")
		public String getBasketIdScheme() {
			return basketIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public BasketId.BasketIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("basketIdScheme")
		public BasketId.BasketIdBuilder setBasketIdScheme(String basketIdScheme) {
			this.basketIdScheme = basketIdScheme==null?null:basketIdScheme;
			return this;
		}
		
		@Override
		public BasketId build() {
			return new BasketId.BasketIdImpl(this);
		}
		
		@Override
		public BasketId.BasketIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketId.BasketIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBasketIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketId.BasketIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketId.BasketIdBuilder o = (BasketId.BasketIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBasketIdScheme(), o.getBasketIdScheme(), this::setBasketIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(basketIdScheme, _that.getBasketIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (basketIdScheme != null ? basketIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketIdBuilder {" +
				"value=" + this.value + ", " +
				"basketIdScheme=" + this.basketIdScheme +
			'}';
		}
	}
}
