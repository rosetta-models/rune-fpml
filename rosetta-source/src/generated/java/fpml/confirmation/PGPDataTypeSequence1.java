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
import fpml.confirmation.PGPDataTypeSequence1;
import fpml.confirmation.PGPDataTypeSequence1.PGPDataTypeSequence1Builder;
import fpml.confirmation.PGPDataTypeSequence1.PGPDataTypeSequence1BuilderImpl;
import fpml.confirmation.PGPDataTypeSequence1.PGPDataTypeSequence1Impl;
import fpml.confirmation.meta.PGPDataTypeSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PGPDataTypeSequence1", builder=PGPDataTypeSequence1.PGPDataTypeSequence1BuilderImpl.class, version="${project.version}")
public interface PGPDataTypeSequence1 extends RosettaModelObject {

	PGPDataTypeSequence1Meta metaData = new PGPDataTypeSequence1Meta();

	/*********************** Getter Methods  ***********************/
	String getPgpKeyPacket();

	/*********************** Build Methods  ***********************/
	PGPDataTypeSequence1 build();
	
	PGPDataTypeSequence1.PGPDataTypeSequence1Builder toBuilder();
	
	static PGPDataTypeSequence1.PGPDataTypeSequence1Builder builder() {
		return new PGPDataTypeSequence1.PGPDataTypeSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PGPDataTypeSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PGPDataTypeSequence1> getType() {
		return PGPDataTypeSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PGPDataTypeSequence1Builder extends PGPDataTypeSequence1, RosettaModelObjectBuilder {
		PGPDataTypeSequence1.PGPDataTypeSequence1Builder setPgpKeyPacket(String pgpKeyPacket);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
		}
		

		PGPDataTypeSequence1.PGPDataTypeSequence1Builder prune();
	}

	/*********************** Immutable Implementation of PGPDataTypeSequence1  ***********************/
	class PGPDataTypeSequence1Impl implements PGPDataTypeSequence1 {
		private final String pgpKeyPacket;
		
		protected PGPDataTypeSequence1Impl(PGPDataTypeSequence1.PGPDataTypeSequence1Builder builder) {
			this.pgpKeyPacket = builder.getPgpKeyPacket();
		}
		
		@Override
		@RosettaAttribute("pgpKeyPacket")
		public String getPgpKeyPacket() {
			return pgpKeyPacket;
		}
		
		@Override
		public PGPDataTypeSequence1 build() {
			return this;
		}
		
		@Override
		public PGPDataTypeSequence1.PGPDataTypeSequence1Builder toBuilder() {
			PGPDataTypeSequence1.PGPDataTypeSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PGPDataTypeSequence1.PGPDataTypeSequence1Builder builder) {
			ofNullable(getPgpKeyPacket()).ifPresent(builder::setPgpKeyPacket);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataTypeSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(pgpKeyPacket, _that.getPgpKeyPacket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpKeyPacket != null ? pgpKeyPacket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataTypeSequence1 {" +
				"pgpKeyPacket=" + this.pgpKeyPacket +
			'}';
		}
	}

	/*********************** Builder Implementation of PGPDataTypeSequence1  ***********************/
	class PGPDataTypeSequence1BuilderImpl implements PGPDataTypeSequence1.PGPDataTypeSequence1Builder {
	
		protected String pgpKeyPacket;
	
		public PGPDataTypeSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pgpKeyPacket")
		public String getPgpKeyPacket() {
			return pgpKeyPacket;
		}
		
		@Override
		@RosettaAttribute("pgpKeyPacket")
		public PGPDataTypeSequence1.PGPDataTypeSequence1Builder setPgpKeyPacket(String pgpKeyPacket) {
			this.pgpKeyPacket = pgpKeyPacket==null?null:pgpKeyPacket;
			return this;
		}
		
		@Override
		public PGPDataTypeSequence1 build() {
			return new PGPDataTypeSequence1.PGPDataTypeSequence1Impl(this);
		}
		
		@Override
		public PGPDataTypeSequence1.PGPDataTypeSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataTypeSequence1.PGPDataTypeSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPgpKeyPacket()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPDataTypeSequence1.PGPDataTypeSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PGPDataTypeSequence1.PGPDataTypeSequence1Builder o = (PGPDataTypeSequence1.PGPDataTypeSequence1Builder) other;
			
			
			merger.mergeBasic(getPgpKeyPacket(), o.getPgpKeyPacket(), this::setPgpKeyPacket);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PGPDataTypeSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(pgpKeyPacket, _that.getPgpKeyPacket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgpKeyPacket != null ? pgpKeyPacket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PGPDataTypeSequence1Builder {" +
				"pgpKeyPacket=" + this.pgpKeyPacket +
			'}';
		}
	}
}
