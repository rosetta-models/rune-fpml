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
import fpml.confirmation.X509IssuerSerialType;
import fpml.confirmation.X509IssuerSerialType.X509IssuerSerialTypeBuilder;
import fpml.confirmation.X509IssuerSerialType.X509IssuerSerialTypeBuilderImpl;
import fpml.confirmation.X509IssuerSerialType.X509IssuerSerialTypeImpl;
import fpml.confirmation.meta.X509IssuerSerialTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="X509IssuerSerialType", builder=X509IssuerSerialType.X509IssuerSerialTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface X509IssuerSerialType extends RosettaModelObject {

	X509IssuerSerialTypeMeta metaData = new X509IssuerSerialTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getX509IssuerName();
	Integer getX509SerialNumber();

	/*********************** Build Methods  ***********************/
	X509IssuerSerialType build();
	
	X509IssuerSerialType.X509IssuerSerialTypeBuilder toBuilder();
	
	static X509IssuerSerialType.X509IssuerSerialTypeBuilder builder() {
		return new X509IssuerSerialType.X509IssuerSerialTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends X509IssuerSerialType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends X509IssuerSerialType> getType() {
		return X509IssuerSerialType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("x509IssuerName"), String.class, getX509IssuerName(), this);
		processor.processBasic(path.newSubPath("x509SerialNumber"), Integer.class, getX509SerialNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface X509IssuerSerialTypeBuilder extends X509IssuerSerialType, RosettaModelObjectBuilder {
		X509IssuerSerialType.X509IssuerSerialTypeBuilder setX509IssuerName(String x509IssuerName);
		X509IssuerSerialType.X509IssuerSerialTypeBuilder setX509SerialNumber(Integer x509SerialNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("x509IssuerName"), String.class, getX509IssuerName(), this);
			processor.processBasic(path.newSubPath("x509SerialNumber"), Integer.class, getX509SerialNumber(), this);
		}
		

		X509IssuerSerialType.X509IssuerSerialTypeBuilder prune();
	}

	/*********************** Immutable Implementation of X509IssuerSerialType  ***********************/
	class X509IssuerSerialTypeImpl implements X509IssuerSerialType {
		private final String x509IssuerName;
		private final Integer x509SerialNumber;
		
		protected X509IssuerSerialTypeImpl(X509IssuerSerialType.X509IssuerSerialTypeBuilder builder) {
			this.x509IssuerName = builder.getX509IssuerName();
			this.x509SerialNumber = builder.getX509SerialNumber();
		}
		
		@Override
		@RosettaAttribute("x509IssuerName")
		public String getX509IssuerName() {
			return x509IssuerName;
		}
		
		@Override
		@RosettaAttribute("x509SerialNumber")
		public Integer getX509SerialNumber() {
			return x509SerialNumber;
		}
		
		@Override
		public X509IssuerSerialType build() {
			return this;
		}
		
		@Override
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder toBuilder() {
			X509IssuerSerialType.X509IssuerSerialTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(X509IssuerSerialType.X509IssuerSerialTypeBuilder builder) {
			ofNullable(getX509IssuerName()).ifPresent(builder::setX509IssuerName);
			ofNullable(getX509SerialNumber()).ifPresent(builder::setX509SerialNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			X509IssuerSerialType _that = getType().cast(o);
		
			if (!Objects.equals(x509IssuerName, _that.getX509IssuerName())) return false;
			if (!Objects.equals(x509SerialNumber, _that.getX509SerialNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (x509IssuerName != null ? x509IssuerName.hashCode() : 0);
			_result = 31 * _result + (x509SerialNumber != null ? x509SerialNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "X509IssuerSerialType {" +
				"x509IssuerName=" + this.x509IssuerName + ", " +
				"x509SerialNumber=" + this.x509SerialNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of X509IssuerSerialType  ***********************/
	class X509IssuerSerialTypeBuilderImpl implements X509IssuerSerialType.X509IssuerSerialTypeBuilder {
	
		protected String x509IssuerName;
		protected Integer x509SerialNumber;
	
		public X509IssuerSerialTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("x509IssuerName")
		public String getX509IssuerName() {
			return x509IssuerName;
		}
		
		@Override
		@RosettaAttribute("x509SerialNumber")
		public Integer getX509SerialNumber() {
			return x509SerialNumber;
		}
		
		@Override
		@RosettaAttribute("x509IssuerName")
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder setX509IssuerName(String x509IssuerName) {
			this.x509IssuerName = x509IssuerName==null?null:x509IssuerName;
			return this;
		}
		@Override
		@RosettaAttribute("x509SerialNumber")
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder setX509SerialNumber(Integer x509SerialNumber) {
			this.x509SerialNumber = x509SerialNumber==null?null:x509SerialNumber;
			return this;
		}
		
		@Override
		public X509IssuerSerialType build() {
			return new X509IssuerSerialType.X509IssuerSerialTypeImpl(this);
		}
		
		@Override
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getX509IssuerName()!=null) return true;
			if (getX509SerialNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			X509IssuerSerialType.X509IssuerSerialTypeBuilder o = (X509IssuerSerialType.X509IssuerSerialTypeBuilder) other;
			
			
			merger.mergeBasic(getX509IssuerName(), o.getX509IssuerName(), this::setX509IssuerName);
			merger.mergeBasic(getX509SerialNumber(), o.getX509SerialNumber(), this::setX509SerialNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			X509IssuerSerialType _that = getType().cast(o);
		
			if (!Objects.equals(x509IssuerName, _that.getX509IssuerName())) return false;
			if (!Objects.equals(x509SerialNumber, _that.getX509SerialNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (x509IssuerName != null ? x509IssuerName.hashCode() : 0);
			_result = 31 * _result + (x509SerialNumber != null ? x509SerialNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "X509IssuerSerialTypeBuilder {" +
				"x509IssuerName=" + this.x509IssuerName + ", " +
				"x509SerialNumber=" + this.x509SerialNumber +
			'}';
		}
	}
}
