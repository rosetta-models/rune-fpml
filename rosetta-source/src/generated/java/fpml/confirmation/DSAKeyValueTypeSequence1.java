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
import fpml.confirmation.DSAKeyValueTypeSequence1;
import fpml.confirmation.DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder;
import fpml.confirmation.DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1BuilderImpl;
import fpml.confirmation.DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Impl;
import fpml.confirmation.meta.DSAKeyValueTypeSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DSAKeyValueTypeSequence1", builder=DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1BuilderImpl.class, version="${project.version}")
public interface DSAKeyValueTypeSequence1 extends RosettaModelObject {

	DSAKeyValueTypeSequence1Meta metaData = new DSAKeyValueTypeSequence1Meta();

	/*********************** Getter Methods  ***********************/
	String getSeed();
	String getPgenCounter();

	/*********************** Build Methods  ***********************/
	DSAKeyValueTypeSequence1 build();
	
	DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder toBuilder();
	
	static DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder builder() {
		return new DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DSAKeyValueTypeSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DSAKeyValueTypeSequence1> getType() {
		return DSAKeyValueTypeSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("seed"), String.class, getSeed(), this);
		processor.processBasic(path.newSubPath("pgenCounter"), String.class, getPgenCounter(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DSAKeyValueTypeSequence1Builder extends DSAKeyValueTypeSequence1, RosettaModelObjectBuilder {
		DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder setSeed(String seed);
		DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder setPgenCounter(String pgenCounter);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("seed"), String.class, getSeed(), this);
			processor.processBasic(path.newSubPath("pgenCounter"), String.class, getPgenCounter(), this);
		}
		

		DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder prune();
	}

	/*********************** Immutable Implementation of DSAKeyValueTypeSequence1  ***********************/
	class DSAKeyValueTypeSequence1Impl implements DSAKeyValueTypeSequence1 {
		private final String seed;
		private final String pgenCounter;
		
		protected DSAKeyValueTypeSequence1Impl(DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder builder) {
			this.seed = builder.getSeed();
			this.pgenCounter = builder.getPgenCounter();
		}
		
		@Override
		@RosettaAttribute("seed")
		public String getSeed() {
			return seed;
		}
		
		@Override
		@RosettaAttribute("pgenCounter")
		public String getPgenCounter() {
			return pgenCounter;
		}
		
		@Override
		public DSAKeyValueTypeSequence1 build() {
			return this;
		}
		
		@Override
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder toBuilder() {
			DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder builder) {
			ofNullable(getSeed()).ifPresent(builder::setSeed);
			ofNullable(getPgenCounter()).ifPresent(builder::setPgenCounter);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueTypeSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(seed, _that.getSeed())) return false;
			if (!Objects.equals(pgenCounter, _that.getPgenCounter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (seed != null ? seed.hashCode() : 0);
			_result = 31 * _result + (pgenCounter != null ? pgenCounter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueTypeSequence1 {" +
				"seed=" + this.seed + ", " +
				"pgenCounter=" + this.pgenCounter +
			'}';
		}
	}

	/*********************** Builder Implementation of DSAKeyValueTypeSequence1  ***********************/
	class DSAKeyValueTypeSequence1BuilderImpl implements DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder {
	
		protected String seed;
		protected String pgenCounter;
	
		public DSAKeyValueTypeSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("seed")
		public String getSeed() {
			return seed;
		}
		
		@Override
		@RosettaAttribute("pgenCounter")
		public String getPgenCounter() {
			return pgenCounter;
		}
		
		@Override
		@RosettaAttribute("seed")
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder setSeed(String seed) {
			this.seed = seed==null?null:seed;
			return this;
		}
		@Override
		@RosettaAttribute("pgenCounter")
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder setPgenCounter(String pgenCounter) {
			this.pgenCounter = pgenCounter==null?null:pgenCounter;
			return this;
		}
		
		@Override
		public DSAKeyValueTypeSequence1 build() {
			return new DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Impl(this);
		}
		
		@Override
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSeed()!=null) return true;
			if (getPgenCounter()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder o = (DSAKeyValueTypeSequence1.DSAKeyValueTypeSequence1Builder) other;
			
			
			merger.mergeBasic(getSeed(), o.getSeed(), this::setSeed);
			merger.mergeBasic(getPgenCounter(), o.getPgenCounter(), this::setPgenCounter);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueTypeSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(seed, _that.getSeed())) return false;
			if (!Objects.equals(pgenCounter, _that.getPgenCounter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (seed != null ? seed.hashCode() : 0);
			_result = 31 * _result + (pgenCounter != null ? pgenCounter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueTypeSequence1Builder {" +
				"seed=" + this.seed + ", " +
				"pgenCounter=" + this.pgenCounter +
			'}';
		}
	}
}
