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
import fpml.confirmation.BasketName;
import fpml.confirmation.BasketName.BasketNameBuilder;
import fpml.confirmation.BasketName.BasketNameBuilderImpl;
import fpml.confirmation.BasketName.BasketNameImpl;
import fpml.confirmation.meta.BasketNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="BasketName", builder=BasketName.BasketNameBuilderImpl.class, version="${project.version}")
public interface BasketName extends RosettaModelObject {

	BasketNameMeta metaData = new BasketNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getBasketNameScheme();

	/*********************** Build Methods  ***********************/
	BasketName build();
	
	BasketName.BasketNameBuilder toBuilder();
	
	static BasketName.BasketNameBuilder builder() {
		return new BasketName.BasketNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasketName> getType() {
		return BasketName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("basketNameScheme"), String.class, getBasketNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketNameBuilder extends BasketName, RosettaModelObjectBuilder {
		BasketName.BasketNameBuilder setValue(String value);
		BasketName.BasketNameBuilder setBasketNameScheme(String basketNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("basketNameScheme"), String.class, getBasketNameScheme(), this);
		}
		

		BasketName.BasketNameBuilder prune();
	}

	/*********************** Immutable Implementation of BasketName  ***********************/
	class BasketNameImpl implements BasketName {
		private final String value;
		private final String basketNameScheme;
		
		protected BasketNameImpl(BasketName.BasketNameBuilder builder) {
			this.value = builder.getValue();
			this.basketNameScheme = builder.getBasketNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("basketNameScheme")
		public String getBasketNameScheme() {
			return basketNameScheme;
		}
		
		@Override
		public BasketName build() {
			return this;
		}
		
		@Override
		public BasketName.BasketNameBuilder toBuilder() {
			BasketName.BasketNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketName.BasketNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBasketNameScheme()).ifPresent(builder::setBasketNameScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(basketNameScheme, _that.getBasketNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (basketNameScheme != null ? basketNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketName {" +
				"value=" + this.value + ", " +
				"basketNameScheme=" + this.basketNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketName  ***********************/
	class BasketNameBuilderImpl implements BasketName.BasketNameBuilder {
	
		protected String value;
		protected String basketNameScheme;
	
		public BasketNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("basketNameScheme")
		public String getBasketNameScheme() {
			return basketNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public BasketName.BasketNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("basketNameScheme")
		public BasketName.BasketNameBuilder setBasketNameScheme(String basketNameScheme) {
			this.basketNameScheme = basketNameScheme==null?null:basketNameScheme;
			return this;
		}
		
		@Override
		public BasketName build() {
			return new BasketName.BasketNameImpl(this);
		}
		
		@Override
		public BasketName.BasketNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketName.BasketNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBasketNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketName.BasketNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketName.BasketNameBuilder o = (BasketName.BasketNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBasketNameScheme(), o.getBasketNameScheme(), this::setBasketNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(basketNameScheme, _that.getBasketNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (basketNameScheme != null ? basketNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketNameBuilder {" +
				"value=" + this.value + ", " +
				"basketNameScheme=" + this.basketNameScheme +
			'}';
		}
	}
}
