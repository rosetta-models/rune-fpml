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
import fpml.confirmation.SPKIDataTypeSequence;
import fpml.confirmation.SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder;
import fpml.confirmation.SPKIDataTypeSequence.SPKIDataTypeSequenceBuilderImpl;
import fpml.confirmation.SPKIDataTypeSequence.SPKIDataTypeSequenceImpl;
import fpml.confirmation.meta.SPKIDataTypeSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SPKIDataTypeSequence", builder=SPKIDataTypeSequence.SPKIDataTypeSequenceBuilderImpl.class, version="${project.version}")
public interface SPKIDataTypeSequence extends RosettaModelObject {

	SPKIDataTypeSequenceMeta metaData = new SPKIDataTypeSequenceMeta();

	/*********************** Getter Methods  ***********************/
	String getSpkiSexp();

	/*********************** Build Methods  ***********************/
	SPKIDataTypeSequence build();
	
	SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder toBuilder();
	
	static SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder() {
		return new SPKIDataTypeSequence.SPKIDataTypeSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SPKIDataTypeSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SPKIDataTypeSequence> getType() {
		return SPKIDataTypeSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spkiSexp"), String.class, getSpkiSexp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SPKIDataTypeSequenceBuilder extends SPKIDataTypeSequence, RosettaModelObjectBuilder {
		SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder setSpkiSexp(String spkiSexp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("spkiSexp"), String.class, getSpkiSexp(), this);
		}
		

		SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of SPKIDataTypeSequence  ***********************/
	class SPKIDataTypeSequenceImpl implements SPKIDataTypeSequence {
		private final String spkiSexp;
		
		protected SPKIDataTypeSequenceImpl(SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder) {
			this.spkiSexp = builder.getSpkiSexp();
		}
		
		@Override
		@RosettaAttribute("spkiSexp")
		public String getSpkiSexp() {
			return spkiSexp;
		}
		
		@Override
		public SPKIDataTypeSequence build() {
			return this;
		}
		
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder toBuilder() {
			SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder) {
			ofNullable(getSpkiSexp()).ifPresent(builder::setSpkiSexp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SPKIDataTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(spkiSexp, _that.getSpkiSexp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spkiSexp != null ? spkiSexp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SPKIDataTypeSequence {" +
				"spkiSexp=" + this.spkiSexp +
			'}';
		}
	}

	/*********************** Builder Implementation of SPKIDataTypeSequence  ***********************/
	class SPKIDataTypeSequenceBuilderImpl implements SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder {
	
		protected String spkiSexp;
	
		public SPKIDataTypeSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("spkiSexp")
		public String getSpkiSexp() {
			return spkiSexp;
		}
		
		@Override
		@RosettaAttribute("spkiSexp")
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder setSpkiSexp(String spkiSexp) {
			this.spkiSexp = spkiSexp==null?null:spkiSexp;
			return this;
		}
		
		@Override
		public SPKIDataTypeSequence build() {
			return new SPKIDataTypeSequence.SPKIDataTypeSequenceImpl(this);
		}
		
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpkiSexp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder o = (SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder) other;
			
			
			merger.mergeBasic(getSpkiSexp(), o.getSpkiSexp(), this::setSpkiSexp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SPKIDataTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(spkiSexp, _that.getSpkiSexp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spkiSexp != null ? spkiSexp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SPKIDataTypeSequenceBuilder {" +
				"spkiSexp=" + this.spkiSexp +
			'}';
		}
	}
}
