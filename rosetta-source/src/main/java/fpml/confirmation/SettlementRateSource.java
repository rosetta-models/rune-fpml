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
import fpml.confirmation.CashSettlementReferenceBanks;
import fpml.confirmation.InformationSource;
import fpml.confirmation.SettlementRateSource;
import fpml.confirmation.SettlementRateSource.SettlementRateSourceBuilder;
import fpml.confirmation.SettlementRateSource.SettlementRateSourceBuilderImpl;
import fpml.confirmation.SettlementRateSource.SettlementRateSourceImpl;
import fpml.confirmation.meta.SettlementRateSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the method for obtaining a settlement rate.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementRateSource", builder=SettlementRateSource.SettlementRateSourceBuilderImpl.class, version="${project.version}")
public interface SettlementRateSource extends RosettaModelObject {

	SettlementRateSourceMeta metaData = new SettlementRateSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 */
	InformationSource getInformationSource();
	/**
	 * A container for a set of reference institutions. These reference institutions may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
	 */
	CashSettlementReferenceBanks getCashSettlementReferenceBanks();

	/*********************** Build Methods  ***********************/
	SettlementRateSource build();
	
	SettlementRateSource.SettlementRateSourceBuilder toBuilder();
	
	static SettlementRateSource.SettlementRateSourceBuilder builder() {
		return new SettlementRateSource.SettlementRateSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementRateSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementRateSource> getType() {
		return SettlementRateSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.class, getCashSettlementReferenceBanks());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementRateSourceBuilder extends SettlementRateSource, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		InformationSource.InformationSourceBuilder getInformationSource();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks();
		SettlementRateSource.SettlementRateSourceBuilder setInformationSource(InformationSource informationSource);
		SettlementRateSource.SettlementRateSourceBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder.class, getCashSettlementReferenceBanks());
		}
		

		SettlementRateSource.SettlementRateSourceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementRateSource  ***********************/
	class SettlementRateSourceImpl implements SettlementRateSource {
		private final InformationSource informationSource;
		private final CashSettlementReferenceBanks cashSettlementReferenceBanks;
		
		protected SettlementRateSourceImpl(SettlementRateSource.SettlementRateSourceBuilder builder) {
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.cashSettlementReferenceBanks = ofNullable(builder.getCashSettlementReferenceBanks()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public InformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		public SettlementRateSource build() {
			return this;
		}
		
		@Override
		public SettlementRateSource.SettlementRateSourceBuilder toBuilder() {
			SettlementRateSource.SettlementRateSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementRateSource.SettlementRateSourceBuilder builder) {
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getCashSettlementReferenceBanks()).ifPresent(builder::setCashSettlementReferenceBanks);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementRateSource _that = getType().cast(o);
		
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementRateSource {" +
				"informationSource=" + this.informationSource + ", " +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementRateSource  ***********************/
	class SettlementRateSourceBuilderImpl implements SettlementRateSource.SettlementRateSourceBuilder {
	
		protected InformationSource.InformationSourceBuilder informationSource;
		protected CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder cashSettlementReferenceBanks;
	
		public SettlementRateSourceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("informationSource")
		public InformationSource.InformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource() {
			InformationSource.InformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getCashSettlementReferenceBanks() {
			return cashSettlementReferenceBanks;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder getOrCreateCashSettlementReferenceBanks() {
			CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder result;
			if (cashSettlementReferenceBanks!=null) {
				result = cashSettlementReferenceBanks;
			}
			else {
				result = cashSettlementReferenceBanks = CashSettlementReferenceBanks.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public SettlementRateSource.SettlementRateSourceBuilder setInformationSource(InformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlementReferenceBanks")
		public SettlementRateSource.SettlementRateSourceBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks) {
			this.cashSettlementReferenceBanks = cashSettlementReferenceBanks==null?null:cashSettlementReferenceBanks.toBuilder();
			return this;
		}
		
		@Override
		public SettlementRateSource build() {
			return new SettlementRateSource.SettlementRateSourceImpl(this);
		}
		
		@Override
		public SettlementRateSource.SettlementRateSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementRateSource.SettlementRateSourceBuilder prune() {
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			if (cashSettlementReferenceBanks!=null && !cashSettlementReferenceBanks.prune().hasData()) cashSettlementReferenceBanks = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getCashSettlementReferenceBanks()!=null && getCashSettlementReferenceBanks().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementRateSource.SettlementRateSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementRateSource.SettlementRateSourceBuilder o = (SettlementRateSource.SettlementRateSourceBuilder) other;
			
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getCashSettlementReferenceBanks(), o.getCashSettlementReferenceBanks(), this::setCashSettlementReferenceBanks);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementRateSource _that = getType().cast(o);
		
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(cashSettlementReferenceBanks, _that.getCashSettlementReferenceBanks())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (cashSettlementReferenceBanks != null ? cashSettlementReferenceBanks.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementRateSourceBuilder {" +
				"informationSource=" + this.informationSource + ", " +
				"cashSettlementReferenceBanks=" + this.cashSettlementReferenceBanks +
			'}';
		}
	}
}
