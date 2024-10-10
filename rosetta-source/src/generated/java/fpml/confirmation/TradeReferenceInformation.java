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
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PartyTradeInformation;
import fpml.confirmation.ProductId;
import fpml.confirmation.ProductType;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TradeReferenceInformation;
import fpml.confirmation.TradeReferenceInformation.TradeReferenceInformationBuilder;
import fpml.confirmation.TradeReferenceInformation.TradeReferenceInformationBuilderImpl;
import fpml.confirmation.TradeReferenceInformation.TradeReferenceInformationImpl;
import fpml.confirmation.meta.TradeReferenceInformationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a type that allows trade identifiers and/or trade information to be represented for a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReferenceInformation", builder=TradeReferenceInformation.TradeReferenceInformationBuilderImpl.class, version="${project.version}")
public interface TradeReferenceInformation extends RosettaModelObject {

	TradeReferenceInformationMeta metaData = new TradeReferenceInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This may be used to describe why a trade was created. This can be used to provide context for a newly created trade that is not part of a post-trade event. For example, it can report that the trade was created as a result of netting activity, or due to a transfer, an allocation process, etc. Omitting this implies that the trade record was created as a result of a negotiated new trade.
	 */
	OriginatingEvent getOriginatingEvent();
	/**
	 * This may be used to describe why a trade was terminated.
	 */
	TerminatingEvent getTerminatingEvent();
	/**
	 * This allows the acknowledging party to supply additional trade identifiers for a trade underlying a request relating to a business event.
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 * This allows the acknowledging party to supply additional trade information about a trade underlying a request relating to a business event.
	 */
	List<? extends PartyTradeInformation> getPartyTradeInformation();
	ProductType getProductType();
	ProductId getProductId();

	/*********************** Build Methods  ***********************/
	TradeReferenceInformation build();
	
	TradeReferenceInformation.TradeReferenceInformationBuilder toBuilder();
	
	static TradeReferenceInformation.TradeReferenceInformationBuilder builder() {
		return new TradeReferenceInformation.TradeReferenceInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReferenceInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeReferenceInformation> getType() {
		return TradeReferenceInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.class, getTerminatingEvent());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.class, getPartyTradeInformation());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReferenceInformationBuilder extends TradeReferenceInformation, RosettaModelObjectBuilder {
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent();
		TerminatingEvent.TerminatingEventBuilder getTerminatingEvent();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyTradeInformation(int _index);
		List<? extends PartyTradeInformation.PartyTradeInformationBuilder> getPartyTradeInformation();
		ProductType.ProductTypeBuilder getOrCreateProductType();
		ProductType.ProductTypeBuilder getProductType();
		ProductId.ProductIdBuilder getOrCreateProductId();
		ProductId.ProductIdBuilder getProductId();
		TradeReferenceInformation.TradeReferenceInformationBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		TradeReferenceInformation.TradeReferenceInformationBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier0);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier1, int _idx);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier2);
		TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier3);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation0);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation1, int _idx);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation2);
		TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation3);
		TradeReferenceInformation.TradeReferenceInformationBuilder setProductType(ProductType productType);
		TradeReferenceInformation.TradeReferenceInformationBuilder setProductId(ProductId productId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.TerminatingEventBuilder.class, getTerminatingEvent());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.PartyTradeInformationBuilder.class, getPartyTradeInformation());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
		}
		

		TradeReferenceInformation.TradeReferenceInformationBuilder prune();
	}

	/*********************** Immutable Implementation of TradeReferenceInformation  ***********************/
	class TradeReferenceInformationImpl implements TradeReferenceInformation {
		private final OriginatingEvent originatingEvent;
		private final TerminatingEvent terminatingEvent;
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends PartyTradeInformation> partyTradeInformation;
		private final ProductType productType;
		private final ProductId productId;
		
		protected TradeReferenceInformationImpl(TradeReferenceInformation.TradeReferenceInformationBuilder builder) {
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.terminatingEvent = ofNullable(builder.getTerminatingEvent()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformation = ofNullable(builder.getPartyTradeInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productType = ofNullable(builder.getProductType()).map(f->f.build()).orElse(null);
			this.productId = ofNullable(builder.getProductId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		public TerminatingEvent getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		public List<? extends PartyTradeInformation> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		@Override
		@RosettaAttribute("productType")
		public ProductType getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("productId")
		public ProductId getProductId() {
			return productId;
		}
		
		@Override
		public TradeReferenceInformation build() {
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder toBuilder() {
			TradeReferenceInformation.TradeReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReferenceInformation.TradeReferenceInformationBuilder builder) {
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTerminatingEvent()).ifPresent(builder::setTerminatingEvent);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartyTradeInformation()).ifPresent(builder::setPartyTradeInformation);
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getProductId()).ifPresent(builder::setProductId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(productId, _that.getProductId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReferenceInformation {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReferenceInformation  ***********************/
	class TradeReferenceInformationBuilderImpl implements TradeReferenceInformation.TradeReferenceInformationBuilder {
	
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected TerminatingEvent.TerminatingEventBuilder terminatingEvent;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<PartyTradeInformation.PartyTradeInformationBuilder> partyTradeInformation = new ArrayList<>();
		protected ProductType.ProductTypeBuilder productType;
		protected ProductId.ProductIdBuilder productId;
	
		public TradeReferenceInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		public TerminatingEvent.TerminatingEventBuilder getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent() {
			TerminatingEvent.TerminatingEventBuilder result;
			if (terminatingEvent!=null) {
				result = terminatingEvent;
			}
			else {
				result = terminatingEvent = TerminatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index) {
		
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(partyTradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		public List<? extends PartyTradeInformation.PartyTradeInformationBuilder> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		public PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyTradeInformation(int _index) {
		
			if (partyTradeInformation==null) {
				this.partyTradeInformation = new ArrayList<>();
			}
			PartyTradeInformation.PartyTradeInformationBuilder result;
			return getIndex(partyTradeInformation, _index, () -> {
						PartyTradeInformation.PartyTradeInformationBuilder newPartyTradeInformation = PartyTradeInformation.builder();
						return newPartyTradeInformation;
					});
		}
		
		@Override
		@RosettaAttribute("productType")
		public ProductType.ProductTypeBuilder getProductType() {
			return productType;
		}
		
		@Override
		public ProductType.ProductTypeBuilder getOrCreateProductType() {
			ProductType.ProductTypeBuilder result;
			if (productType!=null) {
				result = productType;
			}
			else {
				result = productType = ProductType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productId")
		public ProductId.ProductIdBuilder getProductId() {
			return productId;
		}
		
		@Override
		public ProductId.ProductIdBuilder getOrCreateProductId() {
			ProductId.ProductIdBuilder result;
			if (productId!=null) {
				result = productId;
			}
			else {
				result = productId = ProductId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		public TradeReferenceInformation.TradeReferenceInformationBuilder setOriginatingEvent(OriginatingEvent originatingEvent) {
			this.originatingEvent = originatingEvent==null?null:originatingEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminatingEvent")
		public TradeReferenceInformation.TradeReferenceInformationBuilder setTerminatingEvent(TerminatingEvent terminatingEvent) {
			this.terminatingEvent = terminatingEvent==null?null:terminatingEvent.toBuilder();
			return this;
		}
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier) {
			if (partyTradeIdentifier!=null) this.partyTradeIdentifier.add(partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int _idx) {
			getIndex(this.partyTradeIdentifier, _idx, () -> partyTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyTradeIdentifier")
		public TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null)  {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation) {
			if (partyTradeInformation!=null) this.partyTradeInformation.add(partyTradeInformation.toBuilder());
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation, int _idx) {
			getIndex(this.partyTradeInformation, _idx, () -> partyTradeInformation.toBuilder());
			return this;
		}
		@Override 
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations != null) {
				for (PartyTradeInformation toAdd : partyTradeInformations) {
					this.partyTradeInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyTradeInformation")
		public TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations == null)  {
				this.partyTradeInformation = new ArrayList<>();
			}
			else {
				this.partyTradeInformation = partyTradeInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("productType")
		public TradeReferenceInformation.TradeReferenceInformationBuilder setProductType(ProductType productType) {
			this.productType = productType==null?null:productType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("productId")
		public TradeReferenceInformation.TradeReferenceInformationBuilder setProductId(ProductId productId) {
			this.productId = productId==null?null:productId.toBuilder();
			return this;
		}
		
		@Override
		public TradeReferenceInformation build() {
			return new TradeReferenceInformation.TradeReferenceInformationImpl(this);
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder prune() {
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (terminatingEvent!=null && !terminatingEvent.prune().hasData()) terminatingEvent = null;
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeInformation = partyTradeInformation.stream().filter(b->b!=null).<PartyTradeInformation.PartyTradeInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (productType!=null && !productType.prune().hasData()) productType = null;
			if (productId!=null && !productId.prune().hasData()) productId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTerminatingEvent()!=null && getTerminatingEvent().hasData()) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformation()!=null && getPartyTradeInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductType()!=null && getProductType().hasData()) return true;
			if (getProductId()!=null && getProductId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReferenceInformation.TradeReferenceInformationBuilder o = (TradeReferenceInformation.TradeReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTerminatingEvent(), o.getTerminatingEvent(), this::setTerminatingEvent);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPartyTradeInformation(), o.getPartyTradeInformation(), this::getOrCreatePartyTradeInformation);
			merger.mergeRosetta(getProductType(), o.getProductType(), this::setProductType);
			merger.mergeRosetta(getProductId(), o.getProductId(), this::setProductId);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(productId, _that.getProductId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReferenceInformationBuilder {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId +
			'}';
		}
	}
}
