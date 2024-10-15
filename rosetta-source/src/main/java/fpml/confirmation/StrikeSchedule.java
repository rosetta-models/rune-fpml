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
import fpml.confirmation.IdentifiedPayerReceiver;
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.Step;
import fpml.confirmation.StrikeSchedule;
import fpml.confirmation.StrikeSchedule.StrikeScheduleBuilder;
import fpml.confirmation.StrikeSchedule.StrikeScheduleBuilderImpl;
import fpml.confirmation.StrikeSchedule.StrikeScheduleImpl;
import fpml.confirmation.meta.StrikeScheduleMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing a schedule of cap or floor rates.
 * @version ${project.version}
 */
@RosettaDataType(value="StrikeSchedule", builder=StrikeSchedule.StrikeScheduleBuilderImpl.class, version="${project.version}")
public interface StrikeSchedule extends Schedule {

	StrikeScheduleMeta metaData = new StrikeScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The buyer of the option
	 */
	IdentifiedPayerReceiver getBuyer();
	/**
	 * The party that has sold.
	 */
	IdentifiedPayerReceiver getSeller();

	/*********************** Build Methods  ***********************/
	StrikeSchedule build();
	
	StrikeSchedule.StrikeScheduleBuilder toBuilder();
	
	static StrikeSchedule.StrikeScheduleBuilder builder() {
		return new StrikeSchedule.StrikeScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StrikeSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StrikeSchedule> getType() {
		return StrikeSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.class, getBuyer());
		processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.class, getSeller());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrikeScheduleBuilder extends StrikeSchedule, Schedule.ScheduleBuilder {
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller();
		StrikeSchedule.StrikeScheduleBuilder setInitialValue(BigDecimal initialValue);
		StrikeSchedule.StrikeScheduleBuilder addStep(Step step0);
		StrikeSchedule.StrikeScheduleBuilder addStep(Step step1, int _idx);
		StrikeSchedule.StrikeScheduleBuilder addStep(List<? extends Step> step2);
		StrikeSchedule.StrikeScheduleBuilder setStep(List<? extends Step> step3);
		StrikeSchedule.StrikeScheduleBuilder setId(String id);
		StrikeSchedule.StrikeScheduleBuilder setBuyer(IdentifiedPayerReceiver buyer);
		StrikeSchedule.StrikeScheduleBuilder setSeller(IdentifiedPayerReceiver seller);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getBuyer());
			processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getSeller());
		}
		

		StrikeSchedule.StrikeScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of StrikeSchedule  ***********************/
	class StrikeScheduleImpl extends Schedule.ScheduleImpl implements StrikeSchedule {
		private final IdentifiedPayerReceiver buyer;
		private final IdentifiedPayerReceiver seller;
		
		protected StrikeScheduleImpl(StrikeSchedule.StrikeScheduleBuilder builder) {
			super(builder);
			this.buyer = ofNullable(builder.getBuyer()).map(f->f.build()).orElse(null);
			this.seller = ofNullable(builder.getSeller()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyer")
		public IdentifiedPayerReceiver getBuyer() {
			return buyer;
		}
		
		@Override
		@RosettaAttribute("seller")
		public IdentifiedPayerReceiver getSeller() {
			return seller;
		}
		
		@Override
		public StrikeSchedule build() {
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder toBuilder() {
			StrikeSchedule.StrikeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrikeSchedule.StrikeScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyer()).ifPresent(builder::setBuyer);
			ofNullable(getSeller()).ifPresent(builder::setSeller);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeSchedule {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of StrikeSchedule  ***********************/
	class StrikeScheduleBuilderImpl extends Schedule.ScheduleBuilderImpl  implements StrikeSchedule.StrikeScheduleBuilder {
	
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder buyer;
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder seller;
	
		public StrikeScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyer")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer() {
			return buyer;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (buyer!=null) {
				result = buyer;
			}
			else {
				result = buyer = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seller")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller() {
			return seller;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (seller!=null) {
				result = seller;
			}
			else {
				result = seller = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public StrikeSchedule.StrikeScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public StrikeSchedule.StrikeScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public StrikeSchedule.StrikeScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public StrikeSchedule.StrikeScheduleBuilder setStep(List<? extends Step> steps) {
			if (steps == null)  {
				this.step = new ArrayList<>();
			}
			else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public StrikeSchedule.StrikeScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyer")
		public StrikeSchedule.StrikeScheduleBuilder setBuyer(IdentifiedPayerReceiver buyer) {
			this.buyer = buyer==null?null:buyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("seller")
		public StrikeSchedule.StrikeScheduleBuilder setSeller(IdentifiedPayerReceiver seller) {
			this.seller = seller==null?null:seller.toBuilder();
			return this;
		}
		
		@Override
		public StrikeSchedule build() {
			return new StrikeSchedule.StrikeScheduleImpl(this);
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder prune() {
			super.prune();
			if (buyer!=null && !buyer.prune().hasData()) buyer = null;
			if (seller!=null && !seller.prune().hasData()) seller = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyer()!=null && getBuyer().hasData()) return true;
			if (getSeller()!=null && getSeller().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			StrikeSchedule.StrikeScheduleBuilder o = (StrikeSchedule.StrikeScheduleBuilder) other;
			
			merger.mergeRosetta(getBuyer(), o.getBuyer(), this::setBuyer);
			merger.mergeRosetta(getSeller(), o.getSeller(), this::setSeller);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeScheduleBuilder {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}' + " " + super.toString();
		}
	}
}
