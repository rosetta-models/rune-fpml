package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.InterestCapitalizationSequence;
import fpml.confirmation.InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder;
import fpml.confirmation.InterestCapitalizationSequence.InterestCapitalizationSequenceBuilderImpl;
import fpml.confirmation.InterestCapitalizationSequence.InterestCapitalizationSequenceImpl;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.meta.InterestCapitalizationSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestCapitalizationSequence", builder=InterestCapitalizationSequence.InterestCapitalizationSequenceBuilderImpl.class, version="${project.version}")
public interface InterestCapitalizationSequence extends RosettaModelObject {

	InterestCapitalizationSequenceMeta metaData = new InterestCapitalizationSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A schedule that incorporates all sub-periods of an accrual calculation.
	 */
	List<? extends AccrualPeriod> getAccrualSchedule();
	/**
	 * Projected interest payment details.
	 */
	PaymentProjection getProjection();

	/*********************** Build Methods  ***********************/
	InterestCapitalizationSequence build();
	
	InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder toBuilder();
	
	static InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder builder() {
		return new InterestCapitalizationSequence.InterestCapitalizationSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestCapitalizationSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestCapitalizationSequence> getType() {
		return InterestCapitalizationSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.class, getAccrualSchedule());
		processRosetta(path.newSubPath("projection"), processor, PaymentProjection.class, getProjection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestCapitalizationSequenceBuilder extends InterestCapitalizationSequence, RosettaModelObjectBuilder {
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int _index);
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule();
		PaymentProjection.PaymentProjectionBuilder getOrCreateProjection();
		PaymentProjection.PaymentProjectionBuilder getProjection();
		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule0);
		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule1, int _idx);
		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule2);
		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule3);
		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder setProjection(PaymentProjection projection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualSchedule());
			processRosetta(path.newSubPath("projection"), processor, PaymentProjection.PaymentProjectionBuilder.class, getProjection());
		}
		

		InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of InterestCapitalizationSequence  ***********************/
	class InterestCapitalizationSequenceImpl implements InterestCapitalizationSequence {
		private final List<? extends AccrualPeriod> accrualSchedule;
		private final PaymentProjection projection;
		
		protected InterestCapitalizationSequenceImpl(InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder builder) {
			this.accrualSchedule = ofNullable(builder.getAccrualSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.projection = ofNullable(builder.getProjection()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accrualSchedule")
		public List<? extends AccrualPeriod> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		@Override
		@RosettaAttribute("projection")
		public PaymentProjection getProjection() {
			return projection;
		}
		
		@Override
		public InterestCapitalizationSequence build() {
			return this;
		}
		
		@Override
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder toBuilder() {
			InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder builder) {
			ofNullable(getAccrualSchedule()).ifPresent(builder::setAccrualSchedule);
			ofNullable(getProjection()).ifPresent(builder::setProjection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestCapitalizationSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			if (!Objects.equals(projection, _that.getProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCapitalizationSequence {" +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestCapitalizationSequence  ***********************/
	class InterestCapitalizationSequenceBuilderImpl implements InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder {
	
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualSchedule = new ArrayList<>();
		protected PaymentProjection.PaymentProjectionBuilder projection;
	
		public InterestCapitalizationSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accrualSchedule")
		public List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int _index) {
		
			if (accrualSchedule==null) {
				this.accrualSchedule = new ArrayList<>();
			}
			AccrualPeriod.AccrualPeriodBuilder result;
			return getIndex(accrualSchedule, _index, () -> {
						AccrualPeriod.AccrualPeriodBuilder newAccrualSchedule = AccrualPeriod.builder();
						return newAccrualSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("projection")
		public PaymentProjection.PaymentProjectionBuilder getProjection() {
			return projection;
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder getOrCreateProjection() {
			PaymentProjection.PaymentProjectionBuilder result;
			if (projection!=null) {
				result = projection;
			}
			else {
				result = projection = PaymentProjection.builder();
			}
			
			return result;
		}
		
		@Override
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule) {
			if (accrualSchedule!=null) this.accrualSchedule.add(accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule, int _idx) {
			getIndex(this.accrualSchedule, _idx, () -> accrualSchedule.toBuilder());
			return this;
		}
		@Override 
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules != null) {
				for (AccrualPeriod toAdd : accrualSchedules) {
					this.accrualSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accrualSchedule")
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules == null)  {
				this.accrualSchedule = new ArrayList<>();
			}
			else {
				this.accrualSchedule = accrualSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("projection")
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder setProjection(PaymentProjection projection) {
			this.projection = projection==null?null:projection.toBuilder();
			return this;
		}
		
		@Override
		public InterestCapitalizationSequence build() {
			return new InterestCapitalizationSequence.InterestCapitalizationSequenceImpl(this);
		}
		
		@Override
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder prune() {
			accrualSchedule = accrualSchedule.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (projection!=null && !projection.prune().hasData()) projection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccrualSchedule()!=null && getAccrualSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProjection()!=null && getProjection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder o = (InterestCapitalizationSequence.InterestCapitalizationSequenceBuilder) other;
			
			merger.mergeRosetta(getAccrualSchedule(), o.getAccrualSchedule(), this::getOrCreateAccrualSchedule);
			merger.mergeRosetta(getProjection(), o.getProjection(), this::setProjection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestCapitalizationSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			if (!Objects.equals(projection, _that.getProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCapitalizationSequenceBuilder {" +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}';
		}
	}
}
