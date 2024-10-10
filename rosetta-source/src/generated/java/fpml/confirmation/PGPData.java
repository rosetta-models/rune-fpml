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
import fpml.confirmation.PGPData;
import fpml.confirmation.PGPData.PGPDataBuilder;
import fpml.confirmation.PGPData.PGPDataBuilderImpl;
import fpml.confirmation.PGPData.PGPDataImpl;
import fpml.confirmation.PGPDataType;
import fpml.confirmation.PGPDataType.PGPDataTypeBuilder;
import fpml.confirmation.PGPDataType.PGPDataTypeBuilderImpl;
import fpml.confirmation.PGPDataType.PGPDataTypeImpl;
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.PGPDataTypeSequence1;
import fpml.confirmation.meta.PGPDataMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="PGPData", builder=PGPData.PGPDataBuilderImpl.class, version="${project.version}")
public interface PGPData extends PGPDataType {

	PGPDataMeta metaData = new PGPDataMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	PGPData build();
	
	PGPData.PGPDataBuilder toBuilder();
	
	static PGPData.PGPDataBuilder builder() {
		return new PGPData.PGPDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PGPData> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PGPData> getType() {
		return PGPData.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pgpDataTypeSequence0"), processor, PGPDataTypeSequence0.class, getPgpDataTypeSequence0());
		processRosetta(path.newSubPath("pgpDataTypeSequence1"), processor, PGPDataTypeSequence1.class, getPgpDataTypeSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PGPDataBuilder extends PGPData, PGPDataType.PGPDataTypeBuilder {
		PGPData.PGPDataBuilder setPgpDataTypeSequence0(PGPDataTypeSequence0 pgpDataTypeSequence0);
		PGPData.PGPDataBuilder setPgpDataTypeSequence1(PGPDataTypeSequence1 pgpDataTypeSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pgpDataTypeSequence0"), processor, PGPDataTypeSequence0.PGPDataTypeSequence0Builder.class, getPgpDataTypeSequence0());
			processRosetta(path.newSubPath("pgpDataTypeSequence1"), processor, PGPDataTypeSequence1.PGPDataTypeSequence1Builder.class, getPgpDataTypeSequence1());
		}
		

		PGPData.PGPDataBuilder prune();
	}

	/*********************** Immutable Implementation of PGPData  ***********************/
	class PGPDataImpl extends PGPDataType.PGPDataTypeImpl implements PGPData {
		
		protected PGPDataImpl(PGPData.PGPDataBuilder builder) {
			super(builder);
		}
		
		@Override
		public PGPData build() {
			return this;
		}
		
		@Override
		public PGPData.PGPDataBuilder toBuilder() {
			PGPData.PGPDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PGPData.PGPDataBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "PGPData {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PGPData  ***********************/
	class PGPDataBuilderImpl extends PGPDataType.PGPDataTypeBuilderImpl  implements PGPData.PGPDataBuilder {
	
	
		public PGPDataBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pgpDataTypeSequence0")
		public PGPData.PGPDataBuilder setPgpDataTypeSequence0(PGPDataTypeSequence0 pgpDataTypeSequence0) {
			this.pgpDataTypeSequence0 = pgpDataTypeSequence0==null?null:pgpDataTypeSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pgpDataTypeSequence1")
		public PGPData.PGPDataBuilder setPgpDataTypeSequence1(PGPDataTypeSequence1 pgpDataTypeSequence1) {
			this.pgpDataTypeSequence1 = pgpDataTypeSequence1==null?null:pgpDataTypeSequence1.toBuilder();
			return this;
		}
		
		@Override
		public PGPData build() {
			return new PGPData.PGPDataImpl(this);
		}
		
		@Override
		public PGPData.PGPDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPData.PGPDataBuilder prune() {
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
		public PGPData.PGPDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PGPData.PGPDataBuilder o = (PGPData.PGPDataBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "PGPDataBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
