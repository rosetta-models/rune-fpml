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
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.PGPDataTypeSequence0.PGPDataTypeSequence0Builder;
import fpml.confirmation.PGPDataTypeSequence0.PGPDataTypeSequence0BuilderImpl;
import fpml.confirmation.PGPDataTypeSequence0.PGPDataTypeSequence0Impl;
import fpml.confirmation.meta.PGPDataTypeSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PGPDataTypeSequence0", builder=PGPDataTypeSequence0.PGPDataTypeSequence0BuilderImpl.class, version="${project.version}")
public interface PGPDataTypeSequence0 extends RosettaModelObject {

	PGPDataTypeSequence0Meta metaData = new PGPDataTypeSequence0Meta();

	/*********************** Getter Methods  ***********************/
	String getPgpKeyID();
	String getPgpKeyPacket();

	/*********************** Build Methods  ***********************/
	PGPDataTypeSequence0 build();
	
	PGPDataTypeSequence0.PGPDataTypeSequence0Builder toBuilder();
	
	static PGPDataTypeSequence0.PGPDataTypeSequence0Builder builder() {
		return new PGPDataTypeSequence0.PGPDataTypeSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PGPDataTypeSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PGPDataTypeSequence0> getType() {
		return PGPDataTypeSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("pgpKeyID"), String.class, getPgpKeyID(), this);
		processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PGPDataTypeSequence0Builder extends PGPDataTypeSequence0, RosettaModelObjectBuilder {
		PGPDataTypeSequence0.PGPDataTypeSequence0Builder setPgpKeyID(String pgpKeyID);
		PGPDataTypeSequence0.PGPDataTypeSequence0Builder setPgpKeyPacket(String pgpKeyPacket);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("pgpKeyID"), String.class, getPgpKeyID(), this);
			processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
		}
		

		PGPDataTypeSequence0.PGPDataTypeSequence0Builder prune();
	}

	/*********************** Immutable Implementation of PGPDataTypeSequence0  ***********************/
	class PGPDataTypeSequence0Impl implements PGPDataTypeSequence0 {
		private final String pgpKeyID;
		private final String pgpKeyPacket;
		
		protected PGPDataTypeSequence0Impl(PGPDataTypeSequence0.PGPDataTypeSequence0Builder builder) {
			this.pgpKeyID = builder.getPgpKeyID();
			this.pgpKeyPacket = builder.getPgpKeyPacket();
		}
		
		@Override
		@RosettaAttribute("pgpKeyID")
		public String getPgpKeyID() {
			return pgpKeyID;
		}
		
		@Override
		@RosettaAttribute("pgpKeyPacket")
		public String getPgpKeyPacket() {
			return pgpKeyPacket;
		}
		
		@Override
		public PGPDataTypeSequence0 build() {
			return this;
		}
		
		@Override
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder toBuilder() {
			PGPDataTypeSequence0.PGPDataTypeSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PGPDataTypeSequence0.PGPDataTypeSequence0Builder builder) {
			ofNullable(getPgpKeyID()).ifPresent(builder::setPgpKeyID);
			ofNullable(getPgpKeyPacket()).ifPresent(builder::setPgpKeyPacket);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataTypeSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(pgpKeyID, _that.getPgpKeyID())) return false;
			if (!Objects.equals(pgpKeyPacket, _that.getPgpKeyPacket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpKeyID != null ? pgpKeyID.hashCode() : 0);
			_result = 31 * _result + (pgpKeyPacket != null ? pgpKeyPacket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataTypeSequence0 {" +
				"pgpKeyID=" + this.pgpKeyID + ", " +
				"pgpKeyPacket=" + this.pgpKeyPacket +
			'}';
		}
	}

	/*********************** Builder Implementation of PGPDataTypeSequence0  ***********************/
	class PGPDataTypeSequence0BuilderImpl implements PGPDataTypeSequence0.PGPDataTypeSequence0Builder {
	
		protected String pgpKeyID;
		protected String pgpKeyPacket;
	
		public PGPDataTypeSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pgpKeyID")
		public String getPgpKeyID() {
			return pgpKeyID;
		}
		
		@Override
		@RosettaAttribute("pgpKeyPacket")
		public String getPgpKeyPacket() {
			return pgpKeyPacket;
		}
		
		@Override
		@RosettaAttribute("pgpKeyID")
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder setPgpKeyID(String pgpKeyID) {
			this.pgpKeyID = pgpKeyID==null?null:pgpKeyID;
			return this;
		}
		@Override
		@RosettaAttribute("pgpKeyPacket")
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder setPgpKeyPacket(String pgpKeyPacket) {
			this.pgpKeyPacket = pgpKeyPacket==null?null:pgpKeyPacket;
			return this;
		}
		
		@Override
		public PGPDataTypeSequence0 build() {
			return new PGPDataTypeSequence0.PGPDataTypeSequence0Impl(this);
		}
		
		@Override
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPgpKeyID()!=null) return true;
			if (getPgpKeyPacket()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataTypeSequence0.PGPDataTypeSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PGPDataTypeSequence0.PGPDataTypeSequence0Builder o = (PGPDataTypeSequence0.PGPDataTypeSequence0Builder) other;
			
			
			merger.mergeBasic(getPgpKeyID(), o.getPgpKeyID(), this::setPgpKeyID);
			merger.mergeBasic(getPgpKeyPacket(), o.getPgpKeyPacket(), this::setPgpKeyPacket);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataTypeSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(pgpKeyID, _that.getPgpKeyID())) return false;
			if (!Objects.equals(pgpKeyPacket, _that.getPgpKeyPacket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpKeyID != null ? pgpKeyID.hashCode() : 0);
			_result = 31 * _result + (pgpKeyPacket != null ? pgpKeyPacket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataTypeSequence0Builder {" +
				"pgpKeyID=" + this.pgpKeyID + ", " +
				"pgpKeyPacket=" + this.pgpKeyPacket +
			'}';
		}
	}
}
