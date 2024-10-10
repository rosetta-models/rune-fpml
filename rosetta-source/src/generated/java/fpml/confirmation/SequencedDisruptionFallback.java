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
import fpml.confirmation.DisruptionFallback;
import fpml.confirmation.SequencedDisruptionFallback;
import fpml.confirmation.SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder;
import fpml.confirmation.SequencedDisruptionFallback.SequencedDisruptionFallbackBuilderImpl;
import fpml.confirmation.SequencedDisruptionFallback.SequencedDisruptionFallbackImpl;
import fpml.confirmation.meta.SequencedDisruptionFallbackMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A Disruption Fallback with the sequence in which it should be applied relative to other Disruption Fallbacks.
 * @version ${project.version}
 */
@RosettaDataType(value="SequencedDisruptionFallback", builder=SequencedDisruptionFallback.SequencedDisruptionFallbackBuilderImpl.class, version="${project.version}")
public interface SequencedDisruptionFallback extends RosettaModelObject {

	SequencedDisruptionFallbackMeta metaData = new SequencedDisruptionFallbackMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Disruption fallback that applies to the trade.
	 */
	DisruptionFallback getFallback();
	/**
	 * Sequence in which the reference to the disruption fallback should be applied.
	 */
	Integer getSequence();

	/*********************** Build Methods  ***********************/
	SequencedDisruptionFallback build();
	
	SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder toBuilder();
	
	static SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder builder() {
		return new SequencedDisruptionFallback.SequencedDisruptionFallbackBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SequencedDisruptionFallback> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SequencedDisruptionFallback> getType() {
		return SequencedDisruptionFallback.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fallback"), processor, DisruptionFallback.class, getFallback());
		processor.processBasic(path.newSubPath("sequence"), Integer.class, getSequence(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SequencedDisruptionFallbackBuilder extends SequencedDisruptionFallback, RosettaModelObjectBuilder {
		DisruptionFallback.DisruptionFallbackBuilder getOrCreateFallback();
		DisruptionFallback.DisruptionFallbackBuilder getFallback();
		SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder setFallback(DisruptionFallback fallback);
		SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder setSequence(Integer sequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fallback"), processor, DisruptionFallback.DisruptionFallbackBuilder.class, getFallback());
			processor.processBasic(path.newSubPath("sequence"), Integer.class, getSequence(), this);
		}
		

		SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder prune();
	}

	/*********************** Immutable Implementation of SequencedDisruptionFallback  ***********************/
	class SequencedDisruptionFallbackImpl implements SequencedDisruptionFallback {
		private final DisruptionFallback fallback;
		private final Integer sequence;
		
		protected SequencedDisruptionFallbackImpl(SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder builder) {
			this.fallback = ofNullable(builder.getFallback()).map(f->f.build()).orElse(null);
			this.sequence = builder.getSequence();
		}
		
		@Override
		@RosettaAttribute("fallback")
		public DisruptionFallback getFallback() {
			return fallback;
		}
		
		@Override
		@RosettaAttribute("sequence")
		public Integer getSequence() {
			return sequence;
		}
		
		@Override
		public SequencedDisruptionFallback build() {
			return this;
		}
		
		@Override
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder toBuilder() {
			SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder builder) {
			ofNullable(getFallback()).ifPresent(builder::setFallback);
			ofNullable(getSequence()).ifPresent(builder::setSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SequencedDisruptionFallback _that = getType().cast(o);
		
			if (!Objects.equals(fallback, _that.getFallback())) return false;
			if (!Objects.equals(sequence, _that.getSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallback != null ? fallback.hashCode() : 0);
			_result = 31 * _result + (sequence != null ? sequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SequencedDisruptionFallback {" +
				"fallback=" + this.fallback + ", " +
				"sequence=" + this.sequence +
			'}';
		}
	}

	/*********************** Builder Implementation of SequencedDisruptionFallback  ***********************/
	class SequencedDisruptionFallbackBuilderImpl implements SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder {
	
		protected DisruptionFallback.DisruptionFallbackBuilder fallback;
		protected Integer sequence;
	
		public SequencedDisruptionFallbackBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fallback")
		public DisruptionFallback.DisruptionFallbackBuilder getFallback() {
			return fallback;
		}
		
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder getOrCreateFallback() {
			DisruptionFallback.DisruptionFallbackBuilder result;
			if (fallback!=null) {
				result = fallback;
			}
			else {
				result = fallback = DisruptionFallback.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sequence")
		public Integer getSequence() {
			return sequence;
		}
		
		@Override
		@RosettaAttribute("fallback")
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder setFallback(DisruptionFallback fallback) {
			this.fallback = fallback==null?null:fallback.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sequence")
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder setSequence(Integer sequence) {
			this.sequence = sequence==null?null:sequence;
			return this;
		}
		
		@Override
		public SequencedDisruptionFallback build() {
			return new SequencedDisruptionFallback.SequencedDisruptionFallbackImpl(this);
		}
		
		@Override
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder prune() {
			if (fallback!=null && !fallback.prune().hasData()) fallback = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFallback()!=null && getFallback().hasData()) return true;
			if (getSequence()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder o = (SequencedDisruptionFallback.SequencedDisruptionFallbackBuilder) other;
			
			merger.mergeRosetta(getFallback(), o.getFallback(), this::setFallback);
			
			merger.mergeBasic(getSequence(), o.getSequence(), this::setSequence);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SequencedDisruptionFallback _that = getType().cast(o);
		
			if (!Objects.equals(fallback, _that.getFallback())) return false;
			if (!Objects.equals(sequence, _that.getSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallback != null ? fallback.hashCode() : 0);
			_result = 31 * _result + (sequence != null ? sequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SequencedDisruptionFallbackBuilder {" +
				"fallback=" + this.fallback + ", " +
				"sequence=" + this.sequence +
			'}';
		}
	}
}
