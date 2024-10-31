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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilder;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilderImpl;
import fpml.confirmation.DirectionalLeg.DirectionalLegImpl;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.UnderlyerInterestLeg;
import fpml.confirmation.UnderlyerInterestLeg.UnderlyerInterestLegBuilder;
import fpml.confirmation.UnderlyerInterestLeg.UnderlyerInterestLegBuilderImpl;
import fpml.confirmation.UnderlyerInterestLeg.UnderlyerInterestLegImpl;
import fpml.confirmation.meta.UnderlyerInterestLegMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing interest payments associated with and underlyer, such as financing
 * @version ${project.version}
 */
@RosettaDataType(value="UnderlyerInterestLeg", builder=UnderlyerInterestLeg.UnderlyerInterestLegBuilderImpl.class, version="${project.version}")
public interface UnderlyerInterestLeg extends DirectionalLeg {

	UnderlyerInterestLegMeta metaData = new UnderlyerInterestLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 */
	BigDecimal getFixedRate();
	/**
	 * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 */
	List<? extends SpreadSchedule> getSpreadSchedule();

	/*********************** Build Methods  ***********************/
	UnderlyerInterestLeg build();
	
	UnderlyerInterestLeg.UnderlyerInterestLegBuilder toBuilder();
	
	static UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder() {
		return new UnderlyerInterestLeg.UnderlyerInterestLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyerInterestLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnderlyerInterestLeg> getType() {
		return UnderlyerInterestLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyerInterestLegBuilder extends UnderlyerInterestLeg, DirectionalLeg.DirectionalLegBuilder {
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int _index);
		List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule();
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setId(String id);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setFixedRate(BigDecimal fixedRate);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule spreadSchedule0);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule spreadSchedule1, int _idx);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule2);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
		}
		

		UnderlyerInterestLeg.UnderlyerInterestLegBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyerInterestLeg  ***********************/
	class UnderlyerInterestLegImpl extends DirectionalLeg.DirectionalLegImpl implements UnderlyerInterestLeg {
		private final BigDecimal fixedRate;
		private final List<? extends SpreadSchedule> spreadSchedule;
		
		protected UnderlyerInterestLegImpl(UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder) {
			super(builder);
			this.fixedRate = builder.getFixedRate();
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		public List<? extends SpreadSchedule> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public UnderlyerInterestLeg build() {
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder toBuilder() {
			UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyerInterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerInterestLeg {" +
				"fixedRate=" + this.fixedRate + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnderlyerInterestLeg  ***********************/
	class UnderlyerInterestLegBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl  implements UnderlyerInterestLeg.UnderlyerInterestLegBuilder {
	
		protected BigDecimal fixedRate;
		protected List<SpreadSchedule.SpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
	
		public UnderlyerInterestLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		public List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int _index) {
		
			if (spreadSchedule==null) {
				this.spreadSchedule = new ArrayList<>();
			}
			SpreadSchedule.SpreadScheduleBuilder result;
			return getIndex(spreadSchedule, _index, () -> {
						SpreadSchedule.SpreadScheduleBuilder newSpreadSchedule = SpreadSchedule.builder();
						return newSpreadSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("legIdentifier")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null)  {
				this.legIdentifier = new ArrayList<>();
			}
			else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setFixedRate(BigDecimal fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate;
			return this;
		}
		@Override
		@RosettaAttribute("spreadSchedule")
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null)  {
				this.spreadSchedule = new ArrayList<>();
			}
			else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public UnderlyerInterestLeg build() {
			return new UnderlyerInterestLeg.UnderlyerInterestLegImpl(this);
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder prune() {
			super.prune();
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<SpreadSchedule.SpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRate()!=null) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			UnderlyerInterestLeg.UnderlyerInterestLegBuilder o = (UnderlyerInterestLeg.UnderlyerInterestLegBuilder) other;
			
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyerInterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerInterestLegBuilder {" +
				"fixedRate=" + this.fixedRate + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}' + " " + super.toString();
		}
	}
}
