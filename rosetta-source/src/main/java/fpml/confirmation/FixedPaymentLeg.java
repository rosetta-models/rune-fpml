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
import fpml.confirmation.FixedPaymentAmount;
import fpml.confirmation.FixedPaymentLeg;
import fpml.confirmation.FixedPaymentLeg.FixedPaymentLegBuilder;
import fpml.confirmation.FixedPaymentLeg.FixedPaymentLegBuilderImpl;
import fpml.confirmation.FixedPaymentLeg.FixedPaymentLegImpl;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.FixedPaymentLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Fixed Payment Leg of a Dividend Swap.
 * @version ${project.version}
 */
@RosettaDataType(value="FixedPaymentLeg", builder=FixedPaymentLeg.FixedPaymentLegBuilderImpl.class, version="${project.version}")
public interface FixedPaymentLeg extends DirectionalLeg {

	FixedPaymentLegMeta metaData = new FixedPaymentLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Fixed payment of a dividend swap, payment date is relative to a dividend period payment date. Commonly the dividend leg and the fixed payment leg will pay out on the same date, and the payments will be netted.
	 */
	List<? extends FixedPaymentAmount> getFixedPayment();

	/*********************** Build Methods  ***********************/
	FixedPaymentLeg build();
	
	FixedPaymentLeg.FixedPaymentLegBuilder toBuilder();
	
	static FixedPaymentLeg.FixedPaymentLegBuilder builder() {
		return new FixedPaymentLeg.FixedPaymentLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedPaymentLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedPaymentLeg> getType() {
		return FixedPaymentLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("fixedPayment"), processor, FixedPaymentAmount.class, getFixedPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedPaymentLegBuilder extends FixedPaymentLeg, DirectionalLeg.DirectionalLegBuilder {
		FixedPaymentAmount.FixedPaymentAmountBuilder getOrCreateFixedPayment(int _index);
		List<? extends FixedPaymentAmount.FixedPaymentAmountBuilder> getFixedPayment();
		FixedPaymentLeg.FixedPaymentLegBuilder setId(String id);
		FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		FixedPaymentLeg.FixedPaymentLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		FixedPaymentLeg.FixedPaymentLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		FixedPaymentLeg.FixedPaymentLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		FixedPaymentLeg.FixedPaymentLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount fixedPayment0);
		FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount fixedPayment1, int _idx);
		FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(List<? extends FixedPaymentAmount> fixedPayment2);
		FixedPaymentLeg.FixedPaymentLegBuilder setFixedPayment(List<? extends FixedPaymentAmount> fixedPayment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("fixedPayment"), processor, FixedPaymentAmount.FixedPaymentAmountBuilder.class, getFixedPayment());
		}
		

		FixedPaymentLeg.FixedPaymentLegBuilder prune();
	}

	/*********************** Immutable Implementation of FixedPaymentLeg  ***********************/
	class FixedPaymentLegImpl extends DirectionalLeg.DirectionalLegImpl implements FixedPaymentLeg {
		private final List<? extends FixedPaymentAmount> fixedPayment;
		
		protected FixedPaymentLegImpl(FixedPaymentLeg.FixedPaymentLegBuilder builder) {
			super(builder);
			this.fixedPayment = ofNullable(builder.getFixedPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedPayment")
		public List<? extends FixedPaymentAmount> getFixedPayment() {
			return fixedPayment;
		}
		
		@Override
		public FixedPaymentLeg build() {
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder toBuilder() {
			FixedPaymentLeg.FixedPaymentLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedPaymentLeg.FixedPaymentLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedPayment()).ifPresent(builder::setFixedPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPaymentLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPayment, _that.getFixedPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedPayment != null ? fixedPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPaymentLeg {" +
				"fixedPayment=" + this.fixedPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedPaymentLeg  ***********************/
	class FixedPaymentLegBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl  implements FixedPaymentLeg.FixedPaymentLegBuilder {
	
		protected List<FixedPaymentAmount.FixedPaymentAmountBuilder> fixedPayment = new ArrayList<>();
	
		public FixedPaymentLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedPayment")
		public List<? extends FixedPaymentAmount.FixedPaymentAmountBuilder> getFixedPayment() {
			return fixedPayment;
		}
		
		public FixedPaymentAmount.FixedPaymentAmountBuilder getOrCreateFixedPayment(int _index) {
		
			if (fixedPayment==null) {
				this.fixedPayment = new ArrayList<>();
			}
			FixedPaymentAmount.FixedPaymentAmountBuilder result;
			return getIndex(fixedPayment, _index, () -> {
						FixedPaymentAmount.FixedPaymentAmountBuilder newFixedPayment = FixedPaymentAmount.builder();
						return newFixedPayment;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public FixedPaymentLeg.FixedPaymentLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("legIdentifier")
		public FixedPaymentLeg.FixedPaymentLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public FixedPaymentLeg.FixedPaymentLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FixedPaymentLeg.FixedPaymentLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public FixedPaymentLeg.FixedPaymentLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount fixedPayment) {
			if (fixedPayment!=null) this.fixedPayment.add(fixedPayment.toBuilder());
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount fixedPayment, int _idx) {
			getIndex(this.fixedPayment, _idx, () -> fixedPayment.toBuilder());
			return this;
		}
		@Override 
		public FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(List<? extends FixedPaymentAmount> fixedPayments) {
			if (fixedPayments != null) {
				for (FixedPaymentAmount toAdd : fixedPayments) {
					this.fixedPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fixedPayment")
		public FixedPaymentLeg.FixedPaymentLegBuilder setFixedPayment(List<? extends FixedPaymentAmount> fixedPayments) {
			if (fixedPayments == null)  {
				this.fixedPayment = new ArrayList<>();
			}
			else {
				this.fixedPayment = fixedPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FixedPaymentLeg build() {
			return new FixedPaymentLeg.FixedPaymentLegImpl(this);
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder prune() {
			super.prune();
			fixedPayment = fixedPayment.stream().filter(b->b!=null).<FixedPaymentAmount.FixedPaymentAmountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedPayment()!=null && getFixedPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FixedPaymentLeg.FixedPaymentLegBuilder o = (FixedPaymentLeg.FixedPaymentLegBuilder) other;
			
			merger.mergeRosetta(getFixedPayment(), o.getFixedPayment(), this::getOrCreateFixedPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPaymentLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPayment, _that.getFixedPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedPayment != null ? fixedPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPaymentLegBuilder {" +
				"fixedPayment=" + this.fixedPayment +
			'}' + " " + super.toString();
		}
	}
}
