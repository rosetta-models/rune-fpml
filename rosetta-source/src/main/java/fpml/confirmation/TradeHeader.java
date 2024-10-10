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
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.PackageSummary;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PartyTradeInformation;
import fpml.confirmation.ProductSummary;
import fpml.confirmation.TradeHeader;
import fpml.confirmation.TradeHeader.TradeHeaderBuilder;
import fpml.confirmation.TradeHeader.TradeHeaderBuilderImpl;
import fpml.confirmation.TradeHeader.TradeHeaderImpl;
import fpml.confirmation.TradeSummary;
import fpml.confirmation.meta.TradeHeaderMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining trade related information which is not product specific.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeHeader", builder=TradeHeader.TradeHeaderBuilderImpl.class, version="${project.version}")
public interface TradeHeader extends RosettaModelObject {

	TradeHeaderMeta metaData = new TradeHeaderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The trade reference identifier(s) allocated to the trade by the parties involved.
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 * Additional trade information that may be provided by each involved party.
	 */
	List<? extends PartyTradeInformation> getPartyTradeInformation();
	TradeSummary getTradeSummary();
	ProductSummary getProductSummary();
	/**
	 * Information about the trade package if any that the trade originated from.
	 */
	PackageSummary getOriginatingPackage();
	/**
	 * The trade date. This is the date the trade was originally executed. In the case of a novation, the novated part of the trade should be reported (by both the remaining party and the transferee) using a trade date corresponding to the date the novation was agreed. The remaining part of a trade should be reported (by both the transferor and the remaining party) using a trade date corresponding to the original execution date.
	 */
	IdentifiedDate getTradeDate();
	/**
	 * If the trade was cleared (novated) through a central counterparty clearing service, this represents the date the trade was cleared (transferred to the central counterparty).
	 */
	IdentifiedDate getClearedDate();

	/*********************** Build Methods  ***********************/
	TradeHeader build();
	
	TradeHeader.TradeHeaderBuilder toBuilder();
	
	static TradeHeader.TradeHeaderBuilder builder() {
		return new TradeHeader.TradeHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeHeader> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeHeader> getType() {
		return TradeHeader.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.class, getPartyTradeInformation());
		processRosetta(path.newSubPath("tradeSummary"), processor, TradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("productSummary"), processor, ProductSummary.class, getProductSummary());
		processRosetta(path.newSubPath("originatingPackage"), processor, PackageSummary.class, getOriginatingPackage());
		processRosetta(path.newSubPath("tradeDate"), processor, IdentifiedDate.class, getTradeDate());
		processRosetta(path.newSubPath("clearedDate"), processor, IdentifiedDate.class, getClearedDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeHeaderBuilder extends TradeHeader, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyTradeInformation(int _index);
		List<? extends PartyTradeInformation.PartyTradeInformationBuilder> getPartyTradeInformation();
		TradeSummary.TradeSummaryBuilder getOrCreateTradeSummary();
		TradeSummary.TradeSummaryBuilder getTradeSummary();
		ProductSummary.ProductSummaryBuilder getOrCreateProductSummary();
		ProductSummary.ProductSummaryBuilder getProductSummary();
		PackageSummary.PackageSummaryBuilder getOrCreateOriginatingPackage();
		PackageSummary.PackageSummaryBuilder getOriginatingPackage();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateTradeDate();
		IdentifiedDate.IdentifiedDateBuilder getTradeDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateClearedDate();
		IdentifiedDate.IdentifiedDateBuilder getClearedDate();
		TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier0);
		TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier1, int _idx);
		TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier2);
		TradeHeader.TradeHeaderBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier3);
		TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation0);
		TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation1, int _idx);
		TradeHeader.TradeHeaderBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation2);
		TradeHeader.TradeHeaderBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation3);
		TradeHeader.TradeHeaderBuilder setTradeSummary(TradeSummary tradeSummary);
		TradeHeader.TradeHeaderBuilder setProductSummary(ProductSummary productSummary);
		TradeHeader.TradeHeaderBuilder setOriginatingPackage(PackageSummary originatingPackage);
		TradeHeader.TradeHeaderBuilder setTradeDate(IdentifiedDate tradeDate);
		TradeHeader.TradeHeaderBuilder setClearedDate(IdentifiedDate clearedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.PartyTradeInformationBuilder.class, getPartyTradeInformation());
			processRosetta(path.newSubPath("tradeSummary"), processor, TradeSummary.TradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("productSummary"), processor, ProductSummary.ProductSummaryBuilder.class, getProductSummary());
			processRosetta(path.newSubPath("originatingPackage"), processor, PackageSummary.PackageSummaryBuilder.class, getOriginatingPackage());
			processRosetta(path.newSubPath("tradeDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getTradeDate());
			processRosetta(path.newSubPath("clearedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getClearedDate());
		}
		

		TradeHeader.TradeHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of TradeHeader  ***********************/
	class TradeHeaderImpl implements TradeHeader {
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends PartyTradeInformation> partyTradeInformation;
		private final TradeSummary tradeSummary;
		private final ProductSummary productSummary;
		private final PackageSummary originatingPackage;
		private final IdentifiedDate tradeDate;
		private final IdentifiedDate clearedDate;
		
		protected TradeHeaderImpl(TradeHeader.TradeHeaderBuilder builder) {
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformation = ofNullable(builder.getPartyTradeInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.productSummary = ofNullable(builder.getProductSummary()).map(f->f.build()).orElse(null);
			this.originatingPackage = ofNullable(builder.getOriginatingPackage()).map(f->f.build()).orElse(null);
			this.tradeDate = ofNullable(builder.getTradeDate()).map(f->f.build()).orElse(null);
			this.clearedDate = ofNullable(builder.getClearedDate()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("tradeSummary")
		public TradeSummary getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		@RosettaAttribute("productSummary")
		public ProductSummary getProductSummary() {
			return productSummary;
		}
		
		@Override
		@RosettaAttribute("originatingPackage")
		public PackageSummary getOriginatingPackage() {
			return originatingPackage;
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		public IdentifiedDate getTradeDate() {
			return tradeDate;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		public IdentifiedDate getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public TradeHeader build() {
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder toBuilder() {
			TradeHeader.TradeHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeHeader.TradeHeaderBuilder builder) {
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartyTradeInformation()).ifPresent(builder::setPartyTradeInformation);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getProductSummary()).ifPresent(builder::setProductSummary);
			ofNullable(getOriginatingPackage()).ifPresent(builder::setOriginatingPackage);
			ofNullable(getTradeDate()).ifPresent(builder::setTradeDate);
			ofNullable(getClearedDate()).ifPresent(builder::setClearedDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeHeader _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(productSummary, _that.getProductSummary())) return false;
			if (!Objects.equals(originatingPackage, _that.getOriginatingPackage())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (productSummary != null ? productSummary.hashCode() : 0);
			_result = 31 * _result + (originatingPackage != null ? originatingPackage.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeHeader {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"productSummary=" + this.productSummary + ", " +
				"originatingPackage=" + this.originatingPackage + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeHeader  ***********************/
	class TradeHeaderBuilderImpl implements TradeHeader.TradeHeaderBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<PartyTradeInformation.PartyTradeInformationBuilder> partyTradeInformation = new ArrayList<>();
		protected TradeSummary.TradeSummaryBuilder tradeSummary;
		protected ProductSummary.ProductSummaryBuilder productSummary;
		protected PackageSummary.PackageSummaryBuilder originatingPackage;
		protected IdentifiedDate.IdentifiedDateBuilder tradeDate;
		protected IdentifiedDate.IdentifiedDateBuilder clearedDate;
	
		public TradeHeaderBuilderImpl() {
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
		@RosettaAttribute("tradeSummary")
		public TradeSummary.TradeSummaryBuilder getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public TradeSummary.TradeSummaryBuilder getOrCreateTradeSummary() {
			TradeSummary.TradeSummaryBuilder result;
			if (tradeSummary!=null) {
				result = tradeSummary;
			}
			else {
				result = tradeSummary = TradeSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productSummary")
		public ProductSummary.ProductSummaryBuilder getProductSummary() {
			return productSummary;
		}
		
		@Override
		public ProductSummary.ProductSummaryBuilder getOrCreateProductSummary() {
			ProductSummary.ProductSummaryBuilder result;
			if (productSummary!=null) {
				result = productSummary;
			}
			else {
				result = productSummary = ProductSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingPackage")
		public PackageSummary.PackageSummaryBuilder getOriginatingPackage() {
			return originatingPackage;
		}
		
		@Override
		public PackageSummary.PackageSummaryBuilder getOrCreateOriginatingPackage() {
			PackageSummary.PackageSummaryBuilder result;
			if (originatingPackage!=null) {
				result = originatingPackage;
			}
			else {
				result = originatingPackage = PackageSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		public IdentifiedDate.IdentifiedDateBuilder getTradeDate() {
			return tradeDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateTradeDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (tradeDate!=null) {
				result = tradeDate;
			}
			else {
				result = tradeDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		public IdentifiedDate.IdentifiedDateBuilder getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateClearedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (clearedDate!=null) {
				result = clearedDate;
			}
			else {
				result = clearedDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier) {
			if (partyTradeIdentifier!=null) this.partyTradeIdentifier.add(partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int _idx) {
			getIndex(this.partyTradeIdentifier, _idx, () -> partyTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyTradeIdentifier")
		public TradeHeader.TradeHeaderBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
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
		public TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation) {
			if (partyTradeInformation!=null) this.partyTradeInformation.add(partyTradeInformation.toBuilder());
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation, int _idx) {
			getIndex(this.partyTradeInformation, _idx, () -> partyTradeInformation.toBuilder());
			return this;
		}
		@Override 
		public TradeHeader.TradeHeaderBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations != null) {
				for (PartyTradeInformation toAdd : partyTradeInformations) {
					this.partyTradeInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyTradeInformation")
		public TradeHeader.TradeHeaderBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
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
		@RosettaAttribute("tradeSummary")
		public TradeHeader.TradeHeaderBuilder setTradeSummary(TradeSummary tradeSummary) {
			this.tradeSummary = tradeSummary==null?null:tradeSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("productSummary")
		public TradeHeader.TradeHeaderBuilder setProductSummary(ProductSummary productSummary) {
			this.productSummary = productSummary==null?null:productSummary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originatingPackage")
		public TradeHeader.TradeHeaderBuilder setOriginatingPackage(PackageSummary originatingPackage) {
			this.originatingPackage = originatingPackage==null?null:originatingPackage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeDate")
		public TradeHeader.TradeHeaderBuilder setTradeDate(IdentifiedDate tradeDate) {
			this.tradeDate = tradeDate==null?null:tradeDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearedDate")
		public TradeHeader.TradeHeaderBuilder setClearedDate(IdentifiedDate clearedDate) {
			this.clearedDate = clearedDate==null?null:clearedDate.toBuilder();
			return this;
		}
		
		@Override
		public TradeHeader build() {
			return new TradeHeader.TradeHeaderImpl(this);
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeHeader.TradeHeaderBuilder prune() {
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeInformation = partyTradeInformation.stream().filter(b->b!=null).<PartyTradeInformation.PartyTradeInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (productSummary!=null && !productSummary.prune().hasData()) productSummary = null;
			if (originatingPackage!=null && !originatingPackage.prune().hasData()) originatingPackage = null;
			if (tradeDate!=null && !tradeDate.prune().hasData()) tradeDate = null;
			if (clearedDate!=null && !clearedDate.prune().hasData()) clearedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformation()!=null && getPartyTradeInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getProductSummary()!=null && getProductSummary().hasData()) return true;
			if (getOriginatingPackage()!=null && getOriginatingPackage().hasData()) return true;
			if (getTradeDate()!=null && getTradeDate().hasData()) return true;
			if (getClearedDate()!=null && getClearedDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeHeader.TradeHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeHeader.TradeHeaderBuilder o = (TradeHeader.TradeHeaderBuilder) other;
			
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPartyTradeInformation(), o.getPartyTradeInformation(), this::getOrCreatePartyTradeInformation);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getProductSummary(), o.getProductSummary(), this::setProductSummary);
			merger.mergeRosetta(getOriginatingPackage(), o.getOriginatingPackage(), this::setOriginatingPackage);
			merger.mergeRosetta(getTradeDate(), o.getTradeDate(), this::setTradeDate);
			merger.mergeRosetta(getClearedDate(), o.getClearedDate(), this::setClearedDate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeHeader _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(productSummary, _that.getProductSummary())) return false;
			if (!Objects.equals(originatingPackage, _that.getOriginatingPackage())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (productSummary != null ? productSummary.hashCode() : 0);
			_result = 31 * _result + (originatingPackage != null ? originatingPackage.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeHeaderBuilder {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"productSummary=" + this.productSummary + ", " +
				"originatingPackage=" + this.originatingPackage + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}
}
