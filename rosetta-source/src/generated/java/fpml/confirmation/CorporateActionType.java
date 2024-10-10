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
import fpml.confirmation.CorporateActionType;
import fpml.confirmation.CorporateActionType.CorporateActionTypeBuilder;
import fpml.confirmation.CorporateActionType.CorporateActionTypeBuilderImpl;
import fpml.confirmation.CorporateActionType.CorporateActionTypeImpl;
import fpml.confirmation.meta.CorporateActionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes what type of corporate action occurred.
 * @version ${project.version}
 */
@RosettaDataType(value="CorporateActionType", builder=CorporateActionType.CorporateActionTypeBuilderImpl.class, version="${project.version}")
public interface CorporateActionType extends RosettaModelObject {

	CorporateActionTypeMeta metaData = new CorporateActionTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCorporateActionScheme();

	/*********************** Build Methods  ***********************/
	CorporateActionType build();
	
	CorporateActionType.CorporateActionTypeBuilder toBuilder();
	
	static CorporateActionType.CorporateActionTypeBuilder builder() {
		return new CorporateActionType.CorporateActionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorporateActionType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorporateActionType> getType() {
		return CorporateActionType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("corporateActionScheme"), String.class, getCorporateActionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorporateActionTypeBuilder extends CorporateActionType, RosettaModelObjectBuilder {
		CorporateActionType.CorporateActionTypeBuilder setValue(String value);
		CorporateActionType.CorporateActionTypeBuilder setCorporateActionScheme(String corporateActionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("corporateActionScheme"), String.class, getCorporateActionScheme(), this);
		}
		

		CorporateActionType.CorporateActionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CorporateActionType  ***********************/
	class CorporateActionTypeImpl implements CorporateActionType {
		private final String value;
		private final String corporateActionScheme;
		
		protected CorporateActionTypeImpl(CorporateActionType.CorporateActionTypeBuilder builder) {
			this.value = builder.getValue();
			this.corporateActionScheme = builder.getCorporateActionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("corporateActionScheme")
		public String getCorporateActionScheme() {
			return corporateActionScheme;
		}
		
		@Override
		public CorporateActionType build() {
			return this;
		}
		
		@Override
		public CorporateActionType.CorporateActionTypeBuilder toBuilder() {
			CorporateActionType.CorporateActionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorporateActionType.CorporateActionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCorporateActionScheme()).ifPresent(builder::setCorporateActionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorporateActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(corporateActionScheme, _that.getCorporateActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (corporateActionScheme != null ? corporateActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateActionType {" +
				"value=" + this.value + ", " +
				"corporateActionScheme=" + this.corporateActionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CorporateActionType  ***********************/
	class CorporateActionTypeBuilderImpl implements CorporateActionType.CorporateActionTypeBuilder {
	
		protected String value;
		protected String corporateActionScheme;
	
		public CorporateActionTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("corporateActionScheme")
		public String getCorporateActionScheme() {
			return corporateActionScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CorporateActionType.CorporateActionTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("corporateActionScheme")
		public CorporateActionType.CorporateActionTypeBuilder setCorporateActionScheme(String corporateActionScheme) {
			this.corporateActionScheme = corporateActionScheme==null?null:corporateActionScheme;
			return this;
		}
		
		@Override
		public CorporateActionType build() {
			return new CorporateActionType.CorporateActionTypeImpl(this);
		}
		
		@Override
		public CorporateActionType.CorporateActionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateActionType.CorporateActionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCorporateActionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateActionType.CorporateActionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorporateActionType.CorporateActionTypeBuilder o = (CorporateActionType.CorporateActionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCorporateActionScheme(), o.getCorporateActionScheme(), this::setCorporateActionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorporateActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(corporateActionScheme, _that.getCorporateActionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (corporateActionScheme != null ? corporateActionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateActionTypeBuilder {" +
				"value=" + this.value + ", " +
				"corporateActionScheme=" + this.corporateActionScheme +
			'}';
		}
	}
}
