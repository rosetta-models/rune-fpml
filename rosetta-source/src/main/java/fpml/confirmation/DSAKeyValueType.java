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
import fpml.confirmation.DSAKeyValueType;
import fpml.confirmation.DSAKeyValueType.DSAKeyValueTypeBuilder;
import fpml.confirmation.DSAKeyValueType.DSAKeyValueTypeBuilderImpl;
import fpml.confirmation.DSAKeyValueType.DSAKeyValueTypeImpl;
import fpml.confirmation.DSAKeyValueTypeSequence0;
import fpml.confirmation.DSAKeyValueTypeSequence1;
import fpml.confirmation.meta.DSAKeyValueTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DSAKeyValueType", builder=DSAKeyValueType.DSAKeyValueTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DSAKeyValueType extends RosettaModelObject {

	DSAKeyValueTypeMeta metaData = new DSAKeyValueTypeMeta();

	/*********************** Getter Methods  ***********************/
	DSAKeyValueTypeSequence0 getDsaKeyValueTypeSequence0();
	String getG();
	String getY();
	String getJ();
	DSAKeyValueTypeSequence1 getDsaKeyValueTypeSequence1();

	/*********************** Build Methods  ***********************/
	DSAKeyValueType build();
	
	DSAKeyValueType.DSAKeyValueTypeBuilder toBuilder();
	
	static DSAKeyValueType.DSAKeyValueTypeBuilder builder() {
		return new DSAKeyValueType.DSAKeyValueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DSAKeyValueType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DSAKeyValueType> getType() {
		return DSAKeyValueType.class;
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
	interface DSAKeyValueTypeBuilder extends DSAKeyValueType, RosettaModelObjectBuilder {
		DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder getOrCreateDsaKeyValueTypeSequence0();
		DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder getDsaKeyValueTypeSequence0();
		DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder getOrCreateDsaKeyValueTypeSequence1();
		DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder getDsaKeyValueTypeSequence1();
		DSAKeyValueType.DSAKeyValueTypeBuilder setDsaKeyValueTypeSequence0(DSAKeyValueTypeSequence0 dsaKeyValueTypeSequence0);
		DSAKeyValueType.DSAKeyValueTypeBuilder setG(String g);
		DSAKeyValueType.DSAKeyValueTypeBuilder setY(String y);
		DSAKeyValueType.DSAKeyValueTypeBuilder setJ(String j);
		DSAKeyValueType.DSAKeyValueTypeBuilder setDsaKeyValueTypeSequence1(DSAKeyValueTypeSequence1 dsaKeyValueTypeSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dsaKeyValueTypeSequence0"), processor, DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder.class, getDsaKeyValueTypeSequence0());
			processor.processBasic(path.newSubPath("g"), String.class, getG(), this);
			processor.processBasic(path.newSubPath("y"), String.class, getY(), this);
			processor.processBasic(path.newSubPath("j"), String.class, getJ(), this);
			processRosetta(path.newSubPath("dsaKeyValueTypeSequence1"), processor, DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder.class, getDsaKeyValueTypeSequence1());
		}
		

		DSAKeyValueType.DSAKeyValueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of DSAKeyValueType  ***********************/
	class DSAKeyValueTypeImpl implements DSAKeyValueType {
		private final DSAKeyValueTypeSequence0 dsaKeyValueTypeSequence0;
		private final String g;
		private final String y;
		private final String j;
		private final DSAKeyValueTypeSequence1 dsaKeyValueTypeSequence1;
		
		protected DSAKeyValueTypeImpl(DSAKeyValueType.DSAKeyValueTypeBuilder builder) {
			this.dsaKeyValueTypeSequence0 = ofNullable(builder.getDsaKeyValueTypeSequence0()).map(f->f.build()).orElse(null);
			this.g = builder.getG();
			this.y = builder.getY();
			this.j = builder.getJ();
			this.dsaKeyValueTypeSequence1 = ofNullable(builder.getDsaKeyValueTypeSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence0")
		public DSAKeyValueTypeSequence0 getDsaKeyValueTypeSequence0() {
			return dsaKeyValueTypeSequence0;
		}
		
		@Override
		@RosettaAttribute("g")
		public String getG() {
			return g;
		}
		
		@Override
		@RosettaAttribute("y")
		public String getY() {
			return y;
		}
		
		@Override
		@RosettaAttribute("j")
		public String getJ() {
			return j;
		}
		
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence1")
		public DSAKeyValueTypeSequence1 getDsaKeyValueTypeSequence1() {
			return dsaKeyValueTypeSequence1;
		}
		
		@Override
		public DSAKeyValueType build() {
			return this;
		}
		
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder toBuilder() {
			DSAKeyValueType.DSAKeyValueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DSAKeyValueType.DSAKeyValueTypeBuilder builder) {
			ofNullable(getDsaKeyValueTypeSequence0()).ifPresent(builder::setDsaKeyValueTypeSequence0);
			ofNullable(getG()).ifPresent(builder::setG);
			ofNullable(getY()).ifPresent(builder::setY);
			ofNullable(getJ()).ifPresent(builder::setJ);
			ofNullable(getDsaKeyValueTypeSequence1()).ifPresent(builder::setDsaKeyValueTypeSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(dsaKeyValueTypeSequence0, _that.getDsaKeyValueTypeSequence0())) return false;
			if (!Objects.equals(g, _that.getG())) return false;
			if (!Objects.equals(y, _that.getY())) return false;
			if (!Objects.equals(j, _that.getJ())) return false;
			if (!Objects.equals(dsaKeyValueTypeSequence1, _that.getDsaKeyValueTypeSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dsaKeyValueTypeSequence0 != null ? dsaKeyValueTypeSequence0.hashCode() : 0);
			_result = 31 * _result + (g != null ? g.hashCode() : 0);
			_result = 31 * _result + (y != null ? y.hashCode() : 0);
			_result = 31 * _result + (j != null ? j.hashCode() : 0);
			_result = 31 * _result + (dsaKeyValueTypeSequence1 != null ? dsaKeyValueTypeSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueType {" +
				"dsaKeyValueTypeSequence0=" + this.dsaKeyValueTypeSequence0 + ", " +
				"g=" + this.g + ", " +
				"y=" + this.y + ", " +
				"j=" + this.j + ", " +
				"dsaKeyValueTypeSequence1=" + this.dsaKeyValueTypeSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of DSAKeyValueType  ***********************/
	class DSAKeyValueTypeBuilderImpl implements DSAKeyValueType.DSAKeyValueTypeBuilder {
	
		protected DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder dsaKeyValueTypeSequence0;
		protected String g;
		protected String y;
		protected String j;
		protected DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder dsaKeyValueTypeSequence1;
	
		public DSAKeyValueTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence0")
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder getDsaKeyValueTypeSequence0() {
			return dsaKeyValueTypeSequence0;
		}
		
		@Override
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder getOrCreateDsaKeyValueTypeSequence0() {
			DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder result;
			if (dsaKeyValueTypeSequence0!=null) {
				result = dsaKeyValueTypeSequence0;
			}
			else {
				result = dsaKeyValueTypeSequence0 = DSAKeyValueTypeSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("g")
		public String getG() {
			return g;
		}
		
		@Override
		@RosettaAttribute("y")
		public String getY() {
			return y;
		}
		
		@Override
		@RosettaAttribute("j")
		public String getJ() {
			return j;
		}
		
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence1")
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder getDsaKeyValueTypeSequence1() {
			return dsaKeyValueTypeSequence1;
		}
		
		@Override
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder getOrCreateDsaKeyValueTypeSequence1() {
			DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder result;
			if (dsaKeyValueTypeSequence1!=null) {
				result = dsaKeyValueTypeSequence1;
			}
			else {
				result = dsaKeyValueTypeSequence1 = DSAKeyValueTypeSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence0")
		public DSAKeyValueType.DSAKeyValueTypeBuilder setDsaKeyValueTypeSequence0(DSAKeyValueTypeSequence0 dsaKeyValueTypeSequence0) {
			this.dsaKeyValueTypeSequence0 = dsaKeyValueTypeSequence0==null?null:dsaKeyValueTypeSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("g")
		public DSAKeyValueType.DSAKeyValueTypeBuilder setG(String g) {
			this.g = g==null?null:g;
			return this;
		}
		@Override
		@RosettaAttribute("y")
		public DSAKeyValueType.DSAKeyValueTypeBuilder setY(String y) {
			this.y = y==null?null:y;
			return this;
		}
		@Override
		@RosettaAttribute("j")
		public DSAKeyValueType.DSAKeyValueTypeBuilder setJ(String j) {
			this.j = j==null?null:j;
			return this;
		}
		@Override
		@RosettaAttribute("dsaKeyValueTypeSequence1")
		public DSAKeyValueType.DSAKeyValueTypeBuilder setDsaKeyValueTypeSequence1(DSAKeyValueTypeSequence1 dsaKeyValueTypeSequence1) {
			this.dsaKeyValueTypeSequence1 = dsaKeyValueTypeSequence1==null?null:dsaKeyValueTypeSequence1.toBuilder();
			return this;
		}
		
		@Override
		public DSAKeyValueType build() {
			return new DSAKeyValueType.DSAKeyValueTypeImpl(this);
		}
		
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder prune() {
			if (dsaKeyValueTypeSequence0!=null && !dsaKeyValueTypeSequence0.prune().hasData()) dsaKeyValueTypeSequence0 = null;
			if (dsaKeyValueTypeSequence1!=null && !dsaKeyValueTypeSequence1.prune().hasData()) dsaKeyValueTypeSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDsaKeyValueTypeSequence0()!=null && getDsaKeyValueTypeSequence0().hasData()) return true;
			if (getG()!=null) return true;
			if (getY()!=null) return true;
			if (getJ()!=null) return true;
			if (getDsaKeyValueTypeSequence1()!=null && getDsaKeyValueTypeSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DSAKeyValueType.DSAKeyValueTypeBuilder o = (DSAKeyValueType.DSAKeyValueTypeBuilder) other;
			
			merger.mergeRosetta(getDsaKeyValueTypeSequence0(), o.getDsaKeyValueTypeSequence0(), this::setDsaKeyValueTypeSequence0);
			merger.mergeRosetta(getDsaKeyValueTypeSequence1(), o.getDsaKeyValueTypeSequence1(), this::setDsaKeyValueTypeSequence1);
			
			merger.mergeBasic(getG(), o.getG(), this::setG);
			merger.mergeBasic(getY(), o.getY(), this::setY);
			merger.mergeBasic(getJ(), o.getJ(), this::setJ);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(dsaKeyValueTypeSequence0, _that.getDsaKeyValueTypeSequence0())) return false;
			if (!Objects.equals(g, _that.getG())) return false;
			if (!Objects.equals(y, _that.getY())) return false;
			if (!Objects.equals(j, _that.getJ())) return false;
			if (!Objects.equals(dsaKeyValueTypeSequence1, _that.getDsaKeyValueTypeSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dsaKeyValueTypeSequence0 != null ? dsaKeyValueTypeSequence0.hashCode() : 0);
			_result = 31 * _result + (g != null ? g.hashCode() : 0);
			_result = 31 * _result + (y != null ? y.hashCode() : 0);
			_result = 31 * _result + (j != null ? j.hashCode() : 0);
			_result = 31 * _result + (dsaKeyValueTypeSequence1 != null ? dsaKeyValueTypeSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueTypeBuilder {" +
				"dsaKeyValueTypeSequence0=" + this.dsaKeyValueTypeSequence0 + ", " +
				"g=" + this.g + ", " +
				"y=" + this.y + ", " +
				"j=" + this.j + ", " +
				"dsaKeyValueTypeSequence1=" + this.dsaKeyValueTypeSequence1 +
			'}';
		}
	}
}
