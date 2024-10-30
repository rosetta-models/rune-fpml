package cdm.event.common.validation.datarule;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity;
import cdm.event.common.TransferBase;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0-dev.76
 */
@RosettaDataRule("TransferBaseQuantityUnitExists")
@ImplementedBy(TransferBaseQuantityUnitExists.Default.class)
public interface TransferBaseQuantityUnitExists extends Validator<TransferBase> {
	
	String NAME = "TransferBaseQuantityUnitExists";
	String DEFINITION = "if asset -> Cash exists then quantity -> unit -> currency exists else if asset -> Commodity exists then quantity -> unit -> capacityUnit exists else if asset -> Instrument exists then quantity -> unit -> financialUnit exists";
	
	ValidationResult<TransferBase> validate(RosettaPath path, TransferBase transferBase);
	
	class Default implements TransferBaseQuantityUnitExists {
	
		@Override
		public ValidationResult<TransferBase> validate(RosettaPath path, TransferBase transferBase) {
			ComparisonResult result = executeDataRule(transferBase);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TransferBase", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TransferBase", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TransferBase transferBase) {
			try {
				if (exists(MapperS.of(transferBase).<Asset>map("getAsset", _transferBase -> _transferBase.getAsset()).<Cash>map("getCash", asset -> asset.getCash())).getOrDefault(false)) {
					return exists(MapperS.of(transferBase).<NonNegativeQuantity>map("getQuantity", _transferBase -> _transferBase.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()));
				}
				if (exists(MapperS.of(transferBase).<Asset>map("getAsset", _transferBase -> _transferBase.getAsset()).<FieldWithMetaCommodity>map("getCommodity", asset -> asset.getCommodity()).<Commodity>map("getValue", _f->_f.getValue())).getOrDefault(false)) {
					return exists(MapperS.of(transferBase).<NonNegativeQuantity>map("getQuantity", _transferBase -> _transferBase.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit()));
				}
				if (exists(MapperS.of(transferBase).<Asset>map("getAsset", _transferBase -> _transferBase.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument())).getOrDefault(false)) {
					return exists(MapperS.of(transferBase).<NonNegativeQuantity>map("getQuantity", _transferBase -> _transferBase.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TransferBaseQuantityUnitExists {
	
		@Override
		public ValidationResult<TransferBase> validate(RosettaPath path, TransferBase transferBase) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TransferBase", path, DEFINITION);
		}
	}
}
