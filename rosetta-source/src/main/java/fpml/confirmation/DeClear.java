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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.DeClear;
import fpml.confirmation.DeClear.DeClearBuilder;
import fpml.confirmation.DeClear.DeClearBuilderImpl;
import fpml.confirmation.DeClear.DeClearImpl;
import fpml.confirmation.DeclearReason;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.meta.DeClearMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that is has been done.
 * @version ${project.version}
 */
@RosettaDataType(value="DeClear", builder=DeClear.DeClearBuilderImpl.class, version="${project.version}")
public interface DeClear extends RosettaModelObject {

	DeClearMeta metaData = new DeClearMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	Date getEffectiveDate();
	DeclearReason getReason();

	/*********************** Build Methods  ***********************/
	DeClear build();
	
	DeClear.DeClearBuilder toBuilder();
	
	static DeClear.DeClearBuilder builder() {
		return new DeClear.DeClearBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeClear> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DeClear> getType() {
		return DeClear.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("reason"), processor, DeclearReason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeClearBuilder extends DeClear, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		DeclearReason.DeclearReasonBuilder getOrCreateReason();
		DeclearReason.DeclearReasonBuilder getReason();
		DeClear.DeClearBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		DeClear.DeClearBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		DeClear.DeClearBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		DeClear.DeClearBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		DeClear.DeClearBuilder setEffectiveDate(Date effectiveDate);
		DeClear.DeClearBuilder setReason(DeclearReason reason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("reason"), processor, DeclearReason.DeclearReasonBuilder.class, getReason());
		}
		

		DeClear.DeClearBuilder prune();
	}

	/*********************** Immutable Implementation of DeClear  ***********************/
	class DeClearImpl implements DeClear {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final Date effectiveDate;
		private final DeclearReason reason;
		
		protected DeClearImpl(DeClear.DeClearBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.reason = ofNullable(builder.getReason()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("reason")
		public DeclearReason getReason() {
			return reason;
		}
		
		@Override
		public DeClear build() {
			return this;
		}
		
		@Override
		public DeClear.DeClearBuilder toBuilder() {
			DeClear.DeClearBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeClear.DeClearBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeClear _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeClear {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"reason=" + this.reason +
			'}';
		}
	}

	/*********************** Builder Implementation of DeClear  ***********************/
	class DeClearBuilderImpl implements DeClear.DeClearBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Date effectiveDate;
		protected DeclearReason.DeclearReasonBuilder reason;
	
		public DeClearBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("reason")
		public DeclearReason.DeclearReasonBuilder getReason() {
			return reason;
		}
		
		@Override
		public DeclearReason.DeclearReasonBuilder getOrCreateReason() {
			DeclearReason.DeclearReasonBuilder result;
			if (reason!=null) {
				result = reason;
			}
			else {
				result = reason = DeclearReason.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public DeClear.DeClearBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DeClear.DeClearBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public DeClear.DeClearBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DeClear.DeClearBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public DeClear.DeClearBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("reason")
		public DeClear.DeClearBuilder setReason(DeclearReason reason) {
			this.reason = reason==null?null:reason.toBuilder();
			return this;
		}
		
		@Override
		public DeClear build() {
			return new DeClear.DeClearImpl(this);
		}
		
		@Override
		public DeClear.DeClearBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeClear.DeClearBuilder prune() {
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reason!=null && !reason.prune().hasData()) reason = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEffectiveDate()!=null) return true;
			if (getReason()!=null && getReason().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeClear.DeClearBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeClear.DeClearBuilder o = (DeClear.DeClearBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getReason(), o.getReason(), this::setReason);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeClear _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeClearBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"reason=" + this.reason +
			'}';
		}
	}
}
