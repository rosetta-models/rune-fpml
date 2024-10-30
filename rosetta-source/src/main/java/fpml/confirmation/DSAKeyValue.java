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
import fpml.confirmation.DSAKeyValue;
import fpml.confirmation.DSAKeyValue.DSAKeyValueBuilder;
import fpml.confirmation.DSAKeyValue.DSAKeyValueBuilderImpl;
import fpml.confirmation.DSAKeyValue.DSAKeyValueImpl;
import fpml.confirmation.DSAKeyValueType;
import fpml.confirmation.DSAKeyValueType.DSAKeyValueTypeBuilder;
import fpml.confirmation.DSAKeyValueType.DSAKeyValueTypeBuilderImpl;
import fpml.confirmation.DSAKeyValueType.DSAKeyValueTypeImpl;
import fpml.confirmation.DSAKeyValueTypeSequence0;
import fpml.confirmation.DSAKeyValueTypeSequence1;
import fpml.confirmation.meta.DSAKeyValueMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DSAKeyValue", builder=DSAKeyValue.DSAKeyValueBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DSAKeyValue extends DSAKeyValueType {

	DSAKeyValueMeta metaData = new DSAKeyValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DSAKeyValue build();
	
	DSAKeyValue.DSAKeyValueBuilder toBuilder();
	
	static DSAKeyValue.DSAKeyValueBuilder builder() {
		return new DSAKeyValue.DSAKeyValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DSAKeyValue> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DSAKeyValue> getType() {
		return DSAKeyValue.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dsaKeyValueTypeSequence0"), processor, DSAKeyValueTypeSequence0.class, getDsaKeyValueTypeSequence0());
		processor.processBasic(path.newSubPath("g"), String.class, getG(), this);
		processor.processBasic(path.newSubPath("y"), String.class, getY(), this);
		processor.processBasic(path.newSubPath("j"), String.class, getJ(), this);
		processRosetta(path.newSubPath("dsaKeyValueTypeSequence1"), processor, DSAKeyValueTypeSequence1.class, getDsaKeyValueTypeSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DSAKeyValueBuilder extends DSAKeyValue, DSAKeyValueType.DSAKeyValueTypeBuilder {
		DSAKeyValue.DSAKeyValueBuilder setDsaKeyValueTypeSequence0(DSAKeyValueTypeSequence0 dsaKeyValueTypeSequence0);
		DSAKeyValue.DSAKeyValueBuilder setG(String g);
		DSAKeyValue.DSAKeyValueBuilder setY(String y);
		DSAKeyValue.DSAKeyValueBuilder setJ(String j);
		DSAKeyValue.DSAKeyValueBuilder setDsaKeyValueTypeSequence1(DSAKeyValueTypeSequence1 dsaKeyValueTypeSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dsaKeyValueTypeSequence0"), processor, DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder.class, getDsaKeyValueTypeSequence0());
			processor.processBasic(path.newSubPath("g"), String.class, getG(), this);
			processor.processBasic(path.newSubPath("y"), String.class, getY(), this);
			processor.processBasic(path.newSubPath("j"), String.class, getJ(), this);
			processRosetta(path.newSubPath("dsaKeyValueTypeSequence1"), processor, DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder.class, getDsaKeyValueTypeSequence1());
		}
		

		DSAKeyValue.DSAKeyValueBuilder prune();
	}

	/*********************** Immutable Implementation of DSAKeyValue  ***********************/
	class DSAKeyValueImpl extends DSAKeyValueType.DSAKeyValueTypeImpl implements DSAKeyValue {
		
		protected DSAKeyValueImpl(DSAKeyValue.DSAKeyValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public DSAKeyValue build() {
			return this;
		}
		
		@Override
		public DSAKeyValue.DSAKeyValueBuilder toBuilder() {
			DSAKeyValue.DSAKeyValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DSAKeyValue.DSAKeyValueBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DSAKeyValue  ***********************/
	class DSAKeyValueBuilderImpl extends DSAKeyValueType.DSAKeyValueTypeBuilderImpl  implements DSAKeyValue.DSAKeyValueBuilder {
	
	
		public DSAKeyValueBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence0")
		public DSAKeyValue.DSAKeyValueBuilder setDsaKeyValueTypeSequence0(DSAKeyValueTypeSequence0 dsaKeyValueTypeSequence0) {
			this.dsaKeyValueTypeSequence0 = dsaKeyValueTypeSequence0==null?null:dsaKeyValueTypeSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("g")
		public DSAKeyValue.DSAKeyValueBuilder setG(String g) {
			this.g = g==null?null:g;
			return this;
		}
		@Override
		@RosettaAttribute("y")
		public DSAKeyValue.DSAKeyValueBuilder setY(String y) {
			this.y = y==null?null:y;
			return this;
		}
		@Override
		@RosettaAttribute("j")
		public DSAKeyValue.DSAKeyValueBuilder setJ(String j) {
			this.j = j==null?null:j;
			return this;
		}
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence1")
		public DSAKeyValue.DSAKeyValueBuilder setDsaKeyValueTypeSequence1(DSAKeyValueTypeSequence1 dsaKeyValueTypeSequence1) {
			this.dsaKeyValueTypeSequence1 = dsaKeyValueTypeSequence1==null?null:dsaKeyValueTypeSequence1.toBuilder();
			return this;
		}
		
		@Override
		public DSAKeyValue build() {
			return new DSAKeyValue.DSAKeyValueImpl(this);
		}
		
		@Override
		public DSAKeyValue.DSAKeyValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DSAKeyValue.DSAKeyValueBuilder o = (DSAKeyValue.DSAKeyValueBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
