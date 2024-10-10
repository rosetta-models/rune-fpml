package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.validation.FxSettlementDateOrScheduleModelTypeFormatValidator;
import fpml.confirmation.validation.FxSettlementDateOrScheduleModelValidator;
import fpml.confirmation.validation.exists.FxSettlementDateOrScheduleModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxSettlementDateOrScheduleModel.class)
public class FxSettlementDateOrScheduleModelMeta implements RosettaMetaData<FxSettlementDateOrScheduleModel> {

	@Override
	public List<Validator<? super FxSettlementDateOrScheduleModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxSettlementDateOrScheduleModel>create(fpml.confirmation.validation.datarule.FxSettlementDateOrScheduleModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxSettlementDateOrScheduleModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSettlementDateOrScheduleModel> validator() {
		return new FxSettlementDateOrScheduleModelValidator();
	}

	@Override
	public Validator<? super FxSettlementDateOrScheduleModel> typeFormatValidator() {
		return new FxSettlementDateOrScheduleModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSettlementDateOrScheduleModel, Set<String>> onlyExistsValidator() {
		return new FxSettlementDateOrScheduleModelOnlyExistsValidator();
	}
}
