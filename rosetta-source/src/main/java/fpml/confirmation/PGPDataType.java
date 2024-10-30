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
import fpml.confirmation.PGPDataType;
import fpml.confirmation.PGPDataType.PGPDataTypeBuilder;
import fpml.confirmation.PGPDataType.PGPDataTypeBuilderImpl;
import fpml.confirmation.PGPDataType.PGPDataTypeImpl;
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.PGPDataTypeSequence1;
import fpml.confirmation.meta.PGPDataTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PGPDataType", builder=PGPDataType.PGPDataTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PGPDataType extends RosettaModelObject {

	PGPDataTypeMeta metaData = new PGPDataTypeMeta();

	/*********************** Getter Methods  ***********************/
	PGPDataTypeSequence0 getPgpDataTypeSequence0();
	PGPDataTypeSequence1 getPgpDataTypeSequence1();

	/*********************** Build Methods  ***********************/
	PGPDataType build();
	
	PGPDataType.PGPDataTypeBuilder toBuilder();
	
	static PGPDataType.PGPDataTypeBuilder builder() {
		return new PGPDataType.PGPDataTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PGPDataType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PGPDataType> getType() {
		return PGPDataType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pgpDataTypeSequence0"), processor, PGPDataTypeSequence0.class, getPgpDataTypeSequence0());
		processRosetta(path.newSubPath("pgpDataTypeSequence1"), processor, PGPDataTypeSequence1.class, getPgpDataTypeSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PGPDataTypeBuilder extends PGPDataType, RosettaModelObjectBuilder {
		PGPDataTypeSequence0.PGPDataTypeSequence0Builder getOrCreatePgpDataTypeSequence0();
		PGPDataTypeSequence0.PGPDataTypeSequence0Builder getPgpDataTypeSequence0();
		PGPDataTypeSequence1.PGPDataTypeSequence1Builder getOrCreatePgpDataTypeSequence1();
		PGPDataTypeSequence1.PGPDataTypeSequence1Builder getPgpDataTypeSequence1();
		PGPDataType.PGPDataTypeBuilder setPgpDataTypeSequence0(PGPDataTypeSequence0 pgpDataTypeSequence0);
		PGPDataType.PGPDataTypeBuilder setPgpDataTypeSequence1(PGPDataTypeSequence1 pgpDataTypeSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pgpDataTypeSequence0"), processor, PGPDataTypeSequence0.PGPDataTypeSequence0Builder.class, getPgpDataTypeSequence0());
			processRosetta(path.newSubPath("pgpDataTypeSequence1"), processor, PGPDataTypeSequence1.PGPDataTypeSequence1Builder.class, getPgpDataTypeSequence1());
		}
		

		PGPDataType.PGPDataTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PGPDataType  ***********************/
	class PGPDataTypeImpl implements PGPDataType {
		private final PGPDataTypeSequence0 pgpDataTypeSequence0;
		private final PGPDataTypeSequence1 pgpDataTypeSequence1;
		
		protected PGPDataTypeImpl(PGPDataType.PGPDataTypeBuilder builder) {
			this.pgpDataTypeSequence0 = ofNullable(builder.getPgpDataTypeSequence0()).map(f->f.build()).orElse(null);
			this.pgpDataTypeSequence1 = ofNullable(builder.getPgpDataTypeSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pgpDataTypeSequence0")
		public PGPDataTypeSequence0 getPgpDataTypeSequence0() {
			return pgpDataTypeSequence0;
		}
		
		@Override
		@RosettaAttribute("pgpDataTypeSequence1")
		public PGPDataTypeSequence1 getPgpDataTypeSequence1() {
			return pgpDataTypeSequence1;
		}
		
		@Override
		public PGPDataType build() {
			return this;
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder toBuilder() {
			PGPDataType.PGPDataTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PGPDataType.PGPDataTypeBuilder builder) {
			ofNullable(getPgpDataTypeSequence0()).ifPresent(builder::setPgpDataTypeSequence0);
			ofNullable(getPgpDataTypeSequence1()).ifPresent(builder::setPgpDataTypeSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataType _that = getType().cast(o);
		
			if (!Objects.equals(pgpDataTypeSequence0, _that.getPgpDataTypeSequence0())) return false;
			if (!Objects.equals(pgpDataTypeSequence1, _that.getPgpDataTypeSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpDataTypeSequence0 != null ? pgpDataTypeSequence0.hashCode() : 0);
			_result = 31 * _result + (pgpDataTypeSequence1 != null ? pgpDataTypeSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataType {" +
				"pgpDataTypeSequence0=" + this.pgpDataTypeSequence0 + ", " +
				"pgpDataTypeSequence1=" + this.pgpDataTypeSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of PGPDataType  ***********************/
	class PGPDataTypeBuilderImpl implements PGPDataType.PGPDataTypeBuilder {
	
		protected PGPDataTypeSequence0.PGPDataTypeSequence0Builder pgpDataTypeSequence0;
		protected PGPDataTypeSequence1.PGPDataTypeSequence1Builder pgpDataTypeSequence1;
	
		public PGPDataTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pgpDataTypeSequence0")
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder getPgpDataTypeSequence0() {
			return pgpDataTypeSequence0;
		}
		
		@Override
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder getOrCreatePgpDataTypeSequence0() {
			PGPDataTypeSequence0.PGPDataTypeSequence0Builder result;
			if (pgpDataTypeSequence0!=null) {
				result = pgpDataTypeSequence0;
			}
			else {
				result = pgpDataTypeSequence0 = PGPDataTypeSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pgpDataTypeSequence1")
		public PGPDataTypeSequence1.PGPDataTypeSequence1Builder getPgpDataTypeSequence1() {
			return pgpDataTypeSequence1;
		}
		
		@Override
		public PGPDataTypeSequence1.PGPDataTypeSequence1Builder getOrCreatePgpDataTypeSequence1() {
			PGPDataTypeSequence1.PGPDataTypeSequence1Builder result;
			if (pgpDataTypeSequence1!=null) {
				result = pgpDataTypeSequence1;
			}
			else {
				result = pgpDataTypeSequence1 = PGPDataTypeSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pgpDataTypeSequence0")
		public PGPDataType.PGPDataTypeBuilder setPgpDataTypeSequence0(PGPDataTypeSequence0 pgpDataTypeSequence0) {
			this.pgpDataTypeSequence0 = pgpDataTypeSequence0==null?null:pgpDataTypeSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pgpDataTypeSequence1")
		public PGPDataType.PGPDataTypeBuilder setPgpDataTypeSequence1(PGPDataTypeSequence1 pgpDataTypeSequence1) {
			this.pgpDataTypeSequence1 = pgpDataTypeSequence1==null?null:pgpDataTypeSequence1.toBuilder();
			return this;
		}
		
		@Override
		public PGPDataType build() {
			return new PGPDataType.PGPDataTypeImpl(this);
		}
		
		@Override
		public PGPDataType.PGPDataTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataType.PGPDataTypeBuilder prune() {
			if (pgpDataTypeSequence0!=null && !pgpDataTypeSequence0.prune().hasData()) pgpDataTypeSequence0 = null;
			if (pgpDataTypeSequence1!=null && !pgpDataTypeSequence1.prune().hasData()) pgpDataTypeSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPgpDataTypeSequence0()!=null && getPgpDataTypeSequence0().hasData()) return true;
			if (getPgpDataTypeSequence1()!=null && getPgpDataTypeSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataType.PGPDataTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PGPDataType.PGPDataTypeBuilder o = (PGPDataType.PGPDataTypeBuilder) other;
			
			merger.mergeRosetta(getPgpDataTypeSequence0(), o.getPgpDataTypeSequence0(), this::setPgpDataTypeSequence0);
			merger.mergeRosetta(getPgpDataTypeSequence1(), o.getPgpDataTypeSequence1(), this::setPgpDataTypeSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataType _that = getType().cast(o);
		
			if (!Objects.equals(pgpDataTypeSequence0, _that.getPgpDataTypeSequence0())) return false;
			if (!Objects.equals(pgpDataTypeSequence1, _that.getPgpDataTypeSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpDataTypeSequence0 != null ? pgpDataTypeSequence0.hashCode() : 0);
			_result = 31 * _result + (pgpDataTypeSequence1 != null ? pgpDataTypeSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataTypeBuilder {" +
				"pgpDataTypeSequence0=" + this.pgpDataTypeSequence0 + ", " +
				"pgpDataTypeSequence1=" + this.pgpDataTypeSequence1 +
			'}';
		}
	}
}
