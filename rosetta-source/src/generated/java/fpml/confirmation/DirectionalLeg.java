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
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.DirectionalLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base class for all directional leg types with effective date, termination date, where a payer makes a stream of payments of greater than zero value to a receiver.
 * @version ${project.version}
 */
@RosettaDataType(value="DirectionalLeg", builder=DirectionalLeg.DirectionalLegBuilderImpl.class, version="${project.version}")
public interface DirectionalLeg extends Leg {

	DirectionalLegMeta metaData = new DirectionalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Version aware identification of this leg.
	 */
	List<? extends LegIdentifier> getLegIdentifier();
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Specifies the effective date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the effective date of the other leg of the swap.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * Specifies the termination date of this leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically point to the termination date of the other leg of the swap.
	 */
	AdjustableOrRelativeDate getTerminationDate();

	/*********************** Build Methods  ***********************/
	DirectionalLeg build();
	
	DirectionalLeg.DirectionalLegBuilder toBuilder();
	
	static DirectionalLeg.DirectionalLegBuilder builder() {
		return new DirectionalLeg.DirectionalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DirectionalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DirectionalLeg> getType() {
		return DirectionalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DirectionalLegBuilder extends DirectionalLeg, Leg.LegBuilder {
		LegIdentifier.LegIdentifierBuilder getOrCreateLegIdentifier(int _index);
		List<? extends LegIdentifier.LegIdentifierBuilder> getLegIdentifier();
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		DirectionalLeg.DirectionalLegBuilder setId(String id);
		DirectionalLeg.DirectionalLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		DirectionalLeg.DirectionalLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		DirectionalLeg.DirectionalLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		DirectionalLeg.DirectionalLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		DirectionalLeg.DirectionalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		DirectionalLeg.DirectionalLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		DirectionalLeg.DirectionalLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
		}
		

		DirectionalLeg.DirectionalLegBuilder prune();
	}

	/*********************** Immutable Implementation of DirectionalLeg  ***********************/
	class DirectionalLegImpl extends Leg.LegImpl implements DirectionalLeg {
		private final List<? extends LegIdentifier> legIdentifier;
		private final PayerReceiverModel payerReceiverModel;
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		
		protected DirectionalLegImpl(DirectionalLeg.DirectionalLegBuilder builder) {
			super(builder);
			this.legIdentifier = ofNullable(builder.getLegIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("legIdentifier")
		public List<? extends LegIdentifier> getLegIdentifier() {
			return legIdentifier;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public DirectionalLeg build() {
			return this;
		}
		
		@Override
		public DirectionalLeg.DirectionalLegBuilder toBuilder() {
			DirectionalLeg.DirectionalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DirectionalLeg.DirectionalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLegIdentifier()).ifPresent(builder::setLegIdentifier);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(legIdentifier, _that.getLegIdentifier())) return false;
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legIdentifier != null ? legIdentifier.hashCode() : 0);
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLeg {" +
				"legIdentifier=" + this.legIdentifier + ", " +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DirectionalLeg  ***********************/
	class DirectionalLegBuilderImpl extends Leg.LegBuilderImpl  implements DirectionalLeg.DirectionalLegBuilder {
	
		protected List<LegIdentifier.LegIdentifierBuilder> legIdentifier = new ArrayList<>();
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
	
		public DirectionalLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("legIdentifier")
		public List<? extends LegIdentifier.LegIdentifierBuilder> getLegIdentifier() {
			return legIdentifier;
		}
		
		public LegIdentifier.LegIdentifierBuilder getOrCreateLegIdentifier(int _index) {
		
			if (legIdentifier==null) {
				this.legIdentifier = new ArrayList<>();
			}
			LegIdentifier.LegIdentifierBuilder result;
			return getIndex(legIdentifier, _index, () -> {
						LegIdentifier.LegIdentifierBuilder newLegIdentifier = LegIdentifier.builder();
						return newLegIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public DirectionalLeg.DirectionalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public DirectionalLeg.DirectionalLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DirectionalLeg.DirectionalLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public DirectionalLeg.DirectionalLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("legIdentifier")
		public DirectionalLeg.DirectionalLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public DirectionalLeg.DirectionalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public DirectionalLeg.DirectionalLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public DirectionalLeg.DirectionalLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		
		@Override
		public DirectionalLeg build() {
			return new DirectionalLeg.DirectionalLegImpl(this);
		}
		
		@Override
		public DirectionalLeg.DirectionalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLeg.DirectionalLegBuilder prune() {
			super.prune();
			legIdentifier = legIdentifier.stream().filter(b->b!=null).<LegIdentifier.LegIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLegIdentifier()!=null && getLegIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLeg.DirectionalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DirectionalLeg.DirectionalLegBuilder o = (DirectionalLeg.DirectionalLegBuilder) other;
			
			merger.mergeRosetta(getLegIdentifier(), o.getLegIdentifier(), this::getOrCreateLegIdentifier);
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(legIdentifier, _that.getLegIdentifier())) return false;
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legIdentifier != null ? legIdentifier.hashCode() : 0);
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLegBuilder {" +
				"legIdentifier=" + this.legIdentifier + ", " +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate +
			'}' + " " + super.toString();
		}
	}
}
