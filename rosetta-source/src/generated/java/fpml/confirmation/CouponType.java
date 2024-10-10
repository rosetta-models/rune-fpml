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
import fpml.confirmation.CouponType;
import fpml.confirmation.CouponType.CouponTypeBuilder;
import fpml.confirmation.CouponType.CouponTypeBuilderImpl;
import fpml.confirmation.CouponType.CouponTypeImpl;
import fpml.confirmation.meta.CouponTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a scheme of values for specifiying if the bond has a variable coupon, step-up/down coupon or a zero-coupon.
 * @version ${project.version}
 */
@RosettaDataType(value="CouponType", builder=CouponType.CouponTypeBuilderImpl.class, version="${project.version}")
public interface CouponType extends RosettaModelObject {

	CouponTypeMeta metaData = new CouponTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCouponTypeScheme();

	/*********************** Build Methods  ***********************/
	CouponType build();
	
	CouponType.CouponTypeBuilder toBuilder();
	
	static CouponType.CouponTypeBuilder builder() {
		return new CouponType.CouponTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CouponType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CouponType> getType() {
		return CouponType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("couponTypeScheme"), String.class, getCouponTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CouponTypeBuilder extends CouponType, RosettaModelObjectBuilder {
		CouponType.CouponTypeBuilder setValue(String value);
		CouponType.CouponTypeBuilder setCouponTypeScheme(String couponTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("couponTypeScheme"), String.class, getCouponTypeScheme(), this);
		}
		

		CouponType.CouponTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CouponType  ***********************/
	class CouponTypeImpl implements CouponType {
		private final String value;
		private final String couponTypeScheme;
		
		protected CouponTypeImpl(CouponType.CouponTypeBuilder builder) {
			this.value = builder.getValue();
			this.couponTypeScheme = builder.getCouponTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("couponTypeScheme")
		public String getCouponTypeScheme() {
			return couponTypeScheme;
		}
		
		@Override
		public CouponType build() {
			return this;
		}
		
		@Override
		public CouponType.CouponTypeBuilder toBuilder() {
			CouponType.CouponTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CouponType.CouponTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCouponTypeScheme()).ifPresent(builder::setCouponTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CouponType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(couponTypeScheme, _that.getCouponTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (couponTypeScheme != null ? couponTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CouponType {" +
				"value=" + this.value + ", " +
				"couponTypeScheme=" + this.couponTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CouponType  ***********************/
	class CouponTypeBuilderImpl implements CouponType.CouponTypeBuilder {
	
		protected String value;
		protected String couponTypeScheme;
	
		public CouponTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("couponTypeScheme")
		public String getCouponTypeScheme() {
			return couponTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CouponType.CouponTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("couponTypeScheme")
		public CouponType.CouponTypeBuilder setCouponTypeScheme(String couponTypeScheme) {
			this.couponTypeScheme = couponTypeScheme==null?null:couponTypeScheme;
			return this;
		}
		
		@Override
		public CouponType build() {
			return new CouponType.CouponTypeImpl(this);
		}
		
		@Override
		public CouponType.CouponTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CouponType.CouponTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCouponTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CouponType.CouponTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CouponType.CouponTypeBuilder o = (CouponType.CouponTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCouponTypeScheme(), o.getCouponTypeScheme(), this::setCouponTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CouponType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(couponTypeScheme, _that.getCouponTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (couponTypeScheme != null ? couponTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CouponTypeBuilder {" +
				"value=" + this.value + ", " +
				"couponTypeScheme=" + this.couponTypeScheme +
			'}';
		}
	}
}
