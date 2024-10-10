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
import fpml.confirmation.EquityExerciseValuationSettlementSequence;
import fpml.confirmation.EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder;
import fpml.confirmation.EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilderImpl;
import fpml.confirmation.EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceImpl;
import fpml.confirmation.MakeWholeProvisions;
import fpml.confirmation.meta.EquityExerciseValuationSettlementSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="EquityExerciseValuationSettlementSequence", builder=EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilderImpl.class, version="${project.version}")
public interface EquityExerciseValuationSettlementSequence extends RosettaModelObject {

	EquityExerciseValuationSettlementSequenceMeta metaData = new EquityExerciseValuationSettlementSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true then each option not previously exercised will be deemed to be exercised at the expiration time on the expiration date without service of notice unless the buyer notifies the seller that it no longer wishes this to occur.
	 */
	Boolean getAutomaticExercise();
	/**
	 * Provisions covering early exercise of option.
	 */
	MakeWholeProvisions getMakeWholeProvisions();

	/*********************** Build Methods  ***********************/
	EquityExerciseValuationSettlementSequence build();
	
	EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder toBuilder();
	
	static EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder builder() {
		return new EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityExerciseValuationSettlementSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityExerciseValuationSettlementSequence> getType() {
		return EquityExerciseValuationSettlementSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
		processRosetta(path.newSubPath("makeWholeProvisions"), processor, MakeWholeProvisions.class, getMakeWholeProvisions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityExerciseValuationSettlementSequenceBuilder extends EquityExerciseValuationSettlementSequence, RosettaModelObjectBuilder {
		MakeWholeProvisions.MakeWholeProvisionsBuilder getOrCreateMakeWholeProvisions();
		MakeWholeProvisions.MakeWholeProvisionsBuilder getMakeWholeProvisions();
		EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder setAutomaticExercise(Boolean automaticExercise);
		EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder setMakeWholeProvisions(MakeWholeProvisions makeWholeProvisions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
			processRosetta(path.newSubPath("makeWholeProvisions"), processor, MakeWholeProvisions.MakeWholeProvisionsBuilder.class, getMakeWholeProvisions());
		}
		

		EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of EquityExerciseValuationSettlementSequence  ***********************/
	class EquityExerciseValuationSettlementSequenceImpl implements EquityExerciseValuationSettlementSequence {
		private final Boolean automaticExercise;
		private final MakeWholeProvisions makeWholeProvisions;
		
		protected EquityExerciseValuationSettlementSequenceImpl(EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder builder) {
			this.automaticExercise = builder.getAutomaticExercise();
			this.makeWholeProvisions = ofNullable(builder.getMakeWholeProvisions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("makeWholeProvisions")
		public MakeWholeProvisions getMakeWholeProvisions() {
			return makeWholeProvisions;
		}
		
		@Override
		public EquityExerciseValuationSettlementSequence build() {
			return this;
		}
		
		@Override
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder toBuilder() {
			EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder builder) {
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getMakeWholeProvisions()).ifPresent(builder::setMakeWholeProvisions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExerciseValuationSettlementSequence _that = getType().cast(o);
		
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(makeWholeProvisions, _that.getMakeWholeProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (makeWholeProvisions != null ? makeWholeProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExerciseValuationSettlementSequence {" +
				"automaticExercise=" + this.automaticExercise + ", " +
				"makeWholeProvisions=" + this.makeWholeProvisions +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityExerciseValuationSettlementSequence  ***********************/
	class EquityExerciseValuationSettlementSequenceBuilderImpl implements EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder {
	
		protected Boolean automaticExercise;
		protected MakeWholeProvisions.MakeWholeProvisionsBuilder makeWholeProvisions;
	
		public EquityExerciseValuationSettlementSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("makeWholeProvisions")
		public MakeWholeProvisions.MakeWholeProvisionsBuilder getMakeWholeProvisions() {
			return makeWholeProvisions;
		}
		
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder getOrCreateMakeWholeProvisions() {
			MakeWholeProvisions.MakeWholeProvisionsBuilder result;
			if (makeWholeProvisions!=null) {
				result = makeWholeProvisions;
			}
			else {
				result = makeWholeProvisions = MakeWholeProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder setAutomaticExercise(Boolean automaticExercise) {
			this.automaticExercise = automaticExercise==null?null:automaticExercise;
			return this;
		}
		@Override
		@RosettaAttribute("makeWholeProvisions")
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder setMakeWholeProvisions(MakeWholeProvisions makeWholeProvisions) {
			this.makeWholeProvisions = makeWholeProvisions==null?null:makeWholeProvisions.toBuilder();
			return this;
		}
		
		@Override
		public EquityExerciseValuationSettlementSequence build() {
			return new EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceImpl(this);
		}
		
		@Override
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder prune() {
			if (makeWholeProvisions!=null && !makeWholeProvisions.prune().hasData()) makeWholeProvisions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAutomaticExercise()!=null) return true;
			if (getMakeWholeProvisions()!=null && getMakeWholeProvisions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder o = (EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder) other;
			
			merger.mergeRosetta(getMakeWholeProvisions(), o.getMakeWholeProvisions(), this::setMakeWholeProvisions);
			
			merger.mergeBasic(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExerciseValuationSettlementSequence _that = getType().cast(o);
		
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(makeWholeProvisions, _that.getMakeWholeProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (makeWholeProvisions != null ? makeWholeProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExerciseValuationSettlementSequenceBuilder {" +
				"automaticExercise=" + this.automaticExercise + ", " +
				"makeWholeProvisions=" + this.makeWholeProvisions +
			'}';
		}
	}
}
